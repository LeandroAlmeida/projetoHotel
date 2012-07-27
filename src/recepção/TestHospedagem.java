package recepção;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestHospedagem {
	private Fachada fachada;
	private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
	@Before
	public void iniciar(){
		fachada= new Fachada();
	}
	
	@Test
	public void testRealizarHospedagemFalha() throws ParseException {	
		Assert.assertTrue(fachada.isQuartoVago(05,  data("18/04/2012"), data("23/04/2012")));//está vago
		Hospedagem hospedagem1= criarHospedagemModelo();
		fachada.realizarHospedagem(hospedagem1);
		situacoesFalhas();
	}
	
	@Test
	public void testRealizarReservaFalha() throws ParseException {
		Assert.assertTrue(fachada.isQuartoVago(05,  data("18/04/2012"), data("23/04/2012")));//está vago
		Reserva reserva1= criarReservaModelo();
		fachada.realizarReserva(reserva1);
		situacoesFalhas();
	}
	
	private void situacoesFalhas() throws ParseException {
		Assert.assertFalse(fachada.isQuartoVago(05, data("17/04/2012"), data("24/04/2012")));//situação 1
		Assert.assertFalse(fachada.isQuartoVago(05, data("20/04/2012"), data("25/04/2012")));	//situação 2
		Assert.assertFalse(fachada.isQuartoVago(05, data("15/04/2012"), data("22/04/2012")));  //situação 3
	}
	
	private Date data(String s) throws ParseException {
		return formatador.parse(s);	
	}
	
	@Test
	public void testConsultarReserva() throws ParseException{
		Reserva reserva1= criarReservaModelo();
		fachada.realizarReserva(reserva1);
		Assert.assertEquals(fachada.consultaReserva("23"), reserva1);
	}

	@Test(expected=Excecao.class)
	public void testCancelarReserva() throws ParseException{
		Reserva reserva1= criarReservaModelo();
		fachada.realizarReserva(reserva1);
		Assert.assertEquals(fachada.consultaReserva("23"), reserva1);
		fachada.cancelarReserva("23");//cancela reserva
		fachada.consultaReserva("23");//exceção, não existe mais!!!
	}
	
	@Test(expected=Excecao.class)
	public void testConfirmaReserva() throws ParseException{
		Reserva reserva1= criarReservaModelo();
		fachada.realizarReserva(reserva1);
		Assert.assertEquals(fachada.consultaReserva("23"), reserva1);//Confere se a reserva foi feita!
		fachada.confirmaReserva("23");//confirma reserva, ou seja, cria uma hospedagem com os dados de reserva, e remove a reserva, sendo agora uma hospedagem
		Assert.assertEquals(fachada.consultaHospedagem("23").getHospede(), reserva1.getHospede());//confere se virou uma hospedagem mesmo!
		fachada.consultaReserva("23");//exceção não existe mais esse cpf como reserva, agora é hospedagem
	}
	
	@Test(expected=Excecao.class)
	public void testFechaContaTotal() throws ParseException{
		Hospedagem hospedagem1= criarHospedagemModelo();
		fachada.realizarHospedagem(hospedagem1);
		Consumo c=new Consumo();
		Assert.assertEquals(fachada.fechaConta("23", true), 900.00);//fechar conta total
		fachada.consultaHospedagem("23");//não existe mais, depois de fecha conta total a hospedagem é removida
	}
	
	@Test
	public void testFechaContaParcial() throws ParseException{
		Hospedagem hospedagem1= criarHospedagemModelo();
		fachada.realizarHospedagem(hospedagem1);
		Assert.assertEquals(fachada.fechaConta("23", false), 900.00);
		Assert.assertEquals(fachada.consultaHospedagem("23").getHospede(),hospedagem1.getHospede());//Hospedagem continua no sistema
	}
	
	@Test
	public void testListaReservaPendentes() throws ParseException{
		Reserva reserva1= criarReservaModelo();
		fachada.realizarReserva(reserva1);
		Assert.assertEquals(fachada.informaListaReservasPendentes(data("18/04/2012")).size(),1);//retorna uma lista com as reservas esperadas para esse dia
		Assert.assertEquals(fachada.informaListaReservasPendentes(data("18/04/2012")).get(0),reserva1);
	}
	
	private Hospedagem criarHospedagemModelo() throws ParseException{
		Hospedagem h=new Hospedagem();
		
		Quarto q = criarQuarto();
		Hospede hos = criarHospede();
		h.setQuarto(q);
		h.setDataEntrada(formatador.parse("18/04/2012"));
		h.setDataSaida(formatador.parse("23/04/2012"));
		h.setHospede(hos);
		
		return h;
	}
	private Reserva criarReservaModelo() throws ParseException{
		Reserva r=new Reserva();
		Quarto q = criarQuarto();
		Hospede hos = criarHospede();
		r.setQuarto(q);
		r.setDataEntrada(formatador.parse("18/04/2012"));
		r.setDataSaida(formatador.parse("23/04/2012"));
		r.setHospede(hos);
		
		return r;
	}

	private Hospede criarHospede() {
		Hospede hos=new Hospede();
		hos.setCpf("23");
		hos.setDataNacimento("10/04/2012");
		hos.setEmail("meuEmail@dce,ufpb.br");
		hos.setNome("Lucinete");
		hos.setRg("678");
		hos.setTel("1111-1111");
		return hos;
	}

	private Quarto criarQuarto() {
		Quarto q=new Quarto();
		q.setNumero(05);
		q.setTipoDeQuarto("Básico");
		q.setDescricao("Televisão, frigobar, ventilador, sem terraço!!!");
		q.setValor(100.00);
		return q;
	}
	
}
