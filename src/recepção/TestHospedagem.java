package recep��o;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHospedagem {
	private Fachada fachada;
	private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
	
	@Before
	public void iniciar() throws IOException{
		GerentePersistencia.reset();
		fachada= new Fachada();
	}
	
	@After
	public void fim() throws IOException{
		GerentePersistencia.apagarConteudoArquivo();

	}
	
	@Test
	public void testRealizarHospedagem() throws ParseException{
		Hospedagem hospedagem1= criarHospedagemModelo();//Hospedagem com o cliente de cpf 23
		fachada.realizarHospedagem(hospedagem1);
		fachada.consultaHospedagem("23");// Confere se a hospedagem foi realizada
	}
	
	@Test(expected=Excecao.class)
	public void testRealizarHospedagemFalha() throws ParseException{
		Hospedagem hospedagem1= criarHospedagemModelo();//Hospedagem com o cliente de cpf 23
		fachada.realizarHospedagem(hospedagem1);
		fachada.consultaHospedagem("23");// Confere se a hospedagem foi realizada
		Hospedagem hospedagem2= criarHospedagemModelo();// Hospedagem igual ao anterior, ou seja, mesmo quarto e mesmo dia
		fachada.realizarHospedagem(hospedagem2);//exce��o, quarto j� "hospedado" durante estes dias!!!
	}
	
	@Test
	public void testRealizarReserva() throws ParseException {
		Reserva reserva1= criarReservaModelo();//Reserva com cliente de cpf 23
		fachada.realizarReserva(reserva1);
		fachada.consultaReserva("23");// confere se a reserva foi realizada
	}
	
	@Test(expected=Excecao.class)
	public void testRealizarReservaFalha() throws ParseException{
		Reserva reserva1= criarReservaModelo();//Reserva com cliente de cpf 23
		fachada.realizarReserva(reserva1);
		fachada.consultaReserva("23");// confere se a reserva foi realizada
		Reserva reserva2= criarReservaModelo();//Reserva com cliente de cpf 23// Reserva igual ao anterior, ou seja, mesmo quarto e mesmo dia.
		fachada.realizarReserva(reserva2);//exce��o, quarto j� reservado durante estes dias!!!
	}
	
	@Test
	public void testPrazoDataHospedagem() throws ParseException {	
		Assert.assertTrue(fachada.isQuartoVago(05,  data("18/04/2012"), data("23/04/2012")));//est� vago
		Hospedagem hospedagem1= criarHospedagemModelo();
		fachada.realizarHospedagem(hospedagem1);
		situacoesFalhas();//confere todas situa��es possiveis, assegurando que a hospedagem sempre estar� ocupada nesse intervalo de data(de 18 a 23)
	}
	
	@Test
	public void testPrazoDataReserva() throws ParseException {
		Assert.assertTrue(fachada.isQuartoVago(05,  data("18/04/2012"), data("23/04/2012")));//est� vago
		Reserva reserva1= criarReservaModelo();
		fachada.realizarReserva(reserva1);//confere todas situa��es possiveis, assegurando que a reserva(quarto) sempre estar� ocupada nesse intervalo de data(de 18 a 23)
		situacoesFalhas();
	}
	
	private void situacoesFalhas() throws ParseException {
		Assert.assertFalse(fachada.isQuartoVago(05, data("17/04/2012"), data("24/04/2012")));//situa��o 1
		Assert.assertFalse(fachada.isQuartoVago(05, data("20/04/2012"), data("25/04/2012")));	//situa��o 2
		Assert.assertFalse(fachada.isQuartoVago(05, data("15/04/2012"), data("22/04/2012")));  //situa��o 3
	}
	
	private Date data(String s) throws ParseException {
		return formatador.parse(s);	
	}

	@Test(expected=Excecao.class)
	public void testCancelarReserva() throws ParseException{
		Reserva reserva1= criarReservaModelo();
		fachada.realizarReserva(reserva1);
		Assert.assertEquals(fachada.consultaReserva("23"), reserva1);
		fachada.cancelarReserva("23");//cancela reserva
		fachada.consultaReserva("23");//exce��o, n�o existe mais!!!
	}
	
	@Test(expected=Excecao.class)
	public void testConfirmaReserva() throws ParseException{
		Reserva reserva1= criarReservaModelo();
		fachada.realizarReserva(reserva1);
		Assert.assertEquals(fachada.consultaReserva("23"), reserva1);//Confere se a reserva foi feita!
		fachada.confirmaReserva("23");//confirma reserva, ou seja, cria uma hospedagem com os dados de reserva, e remove a reserva, sendo agora uma hospedagem
		Assert.assertEquals(fachada.consultaHospedagem("23").getHospede(), reserva1.getHospede());//confere se virou uma hospedagem mesmo!
		fachada.consultaReserva("23");//exce��o n�o existe mais esse cpf como reserva, agora � hospedagem
	}
	
	@Test(expected=Excecao.class)
	public void testAddConsumoDeHospedagem() throws ParseException{
		Hospedagem hospedagem1= criarHospedagemModelo();
		fachada.realizarHospedagem(hospedagem1);
		Consumo c=criarConsumo();
		fachada.adicionarConsumo(05, c);
		Assert.assertEquals(fachada.consultaHospedagem("23").getListaDeComsumo().size(), 1);// Adicionou a lista de consumo
		Consumo c2=new Consumo();
		c2.setDescricao("Jantar executivo");
		c2.setValorConsumo(20.0);
		fachada.adicionarConsumo(05, c2);
		Assert.assertEquals(fachada.consultaHospedagem("23").getListaDeComsumo().size(), 2);// Adicionou a lista de consumo, agora j� tem 2 pedidos na lista de consumo.
		fachada.adicionarConsumo(04, c);// Exce��o este quarto esta vago, por isso n�o pode adicionar consumo
	}
	
	@Test(expected=Excecao.class)
	public void testFechaContaTotal() throws ParseException{
		Hospedagem hospedagem1= criarHospedagemModelo();
		fachada.realizarHospedagem(hospedagem1);
		Consumo c=criarConsumo();
		fachada.adicionarConsumo(05, c);
		Assert.assertEquals(fachada.fechaConta("23", formatador.parse("23/04/2012")), 580.00);//fechar conta total
		fachada.consultaHospedagem("23");//n�o existe mais, depois de fecha conta total a hospedagem � removida
	}
	
	@Test(expected=Excecao.class)
	public void testFechaContaParcial() throws ParseException{
		Hospedagem hospedagem1= criarHospedagemModelo();
		fachada.realizarHospedagem(hospedagem1);
		Assert.assertEquals(fachada.fechaConta("23", formatador.parse("20/04/2012")), 200.00);
		Assert.assertEquals(fachada.consultaHospedagem("23").getHospede(),hospedagem1.getHospede());//Hospedagem continua no sistema, por�m, a conta ja foi paga at� dia 20
		Consumo c=criarConsumo();
		fachada.adicionarConsumo(05, c);
		Assert.assertEquals(fachada.fechaConta("23", formatador.parse("23/04/2012")), 380.00);//fechar conta total, pois 23 � o dia de saida
		fachada.consultaHospedagem("23");//n�o existe mais, depois de fecha conta total a hospedagem � removida
	}
	
	@Test
	public void testListaReservaPendentesParaUmDia() throws ParseException{
		Assert.assertEquals(fachada.informaListaReservasPendentes(data("18/04/2012")).size(),0);// N�o existe reserva neste dia
		Reserva reserva1= criarReservaModelo();// data da reserva 18/04
		fachada.realizarReserva(reserva1);
		Assert.assertEquals(fachada.informaListaReservasPendentes(data("18/04/2012")).size(),1);//retorna uma lista com as reservas esperadas para esse dia
		Assert.assertEquals(fachada.informaListaReservasPendentes(data("18/04/2012")).get(0),reserva1);
	}
	
	@Test
	public void testListaHospedagemEncerraNesteDia() throws ParseException{
		Hospedagem hospedagem1= criarHospedagemModelo();// dia de saida 23
		fachada.realizarHospedagem(hospedagem1);
		Assert.assertEquals(fachada.informaListaHospedagemEncerraNesteDia(data("18/04/2012")).size(),0);
		Assert.assertEquals(fachada.informaListaHospedagemEncerraNesteDia(data("23/04/2012")).size(),1);
		Assert.assertEquals(fachada.informaListaHospedagemEncerraNesteDia(data("23/04/2012")).get(0),hospedagem1);
		
	}
	
	@Test
	public void testHistoricoDeHospede() throws ParseException{
		Hospedagem hospedagem1= criarHospedagemModelo();// nome do hospede modelo � Lucinete e o cpf � 23
		fachada.realizarHospedagem(hospedagem1);
		Consumo c=criarConsumo();
		fachada.adicionarConsumo(05, c);
		Assert.assertEquals(fachada.fechaConta("23", formatador.parse("20/04/2012")), 280.00);// hospedagem do dia 18 ate 23, esta fechando conta parcial at� dia 20
		Assert.assertEquals(fachada.consultaHospedagem("23").getHospede(),hospedagem1.getHospede());//Hospedagem continua no sistema
		c=new Consumo();// adicionado dois consumos, 1 vinho tinto(consumo modelo) e um jantar
		c.setDescricao("Jantar Simples");
		c.setValorConsumo(10.0);
		fachada.adicionarConsumo(05, c);
		Assert.assertEquals(fachada.fechaConta("23", formatador.parse("23/04/2012")), 310.00);//fechou conta total
		Hospede h= fachada.consultarHospede("23");
		Assert.assertEquals(h.getNome(),"Lucinete");//Hospede modelo que foi cadastrado
		Assert.assertEquals(h.getHistorico().size(), 1);//Esse hospede teve uma hospedagem
		Assert.assertEquals(h.getHistorico().get(0).getQuarto().getTipoDeQuarto(),"B�sico");//Nessa hospedagem  seu quarto era basico(correto)
		Assert.assertEquals(h.getHistorico().get(0).getListaDeComsumo().size(),2);//Consumio 2 produtos
		Assert.assertEquals(h.getHistorico().get(0).getListaDeComsumo().get(0).getDescricao(),"Vinho Tinto Seco");//Um desses produtos era um vinho!
		Assert.assertEquals(h.getHistorico().get(0).getValorfinal(),590.0);// Valor final pago, somando tudo(diarias, consumos)!!!
	}
	
	@Test
	public void testHistoricoDeHospedeComVariasHospedagem() throws ParseException{
		//primeira hospedagem, do dia 17 ate 23, com uma lista de consumo de 2 produto e total r$ 590
		Hospedagem hospedagem1= criarHospedagemModelo();// nome do hospede modelo � Lucinete e o cpf � 23
		fachada.realizarHospedagem(hospedagem1);
		Consumo c=criarConsumo();
		fachada.adicionarConsumo(05, c);
		Assert.assertEquals(fachada.fechaConta("23", formatador.parse("20/04/2012")), 280.00);// hospedagem do dia 18 ate 23, esta fechando conta parcial at� dia 20
		Assert.assertEquals(fachada.consultaHospedagem("23").getHospede(),hospedagem1.getHospede());//Hospedagem continua no sistema
		c=new Consumo();// adicionado dois consumos, 1 vinho tinto(consumo modelo) e um jantar
		c.setDescricao("Jantar Simples");
		c.setValorConsumo(10.0);
		fachada.adicionarConsumo(05, c);
		Assert.assertEquals(fachada.fechaConta("23", formatador.parse("23/04/2012")), 310.00);//fechou conta total
		//segunda hospedagem, so hospedage(d�aria) de 24 a 27 com total r$ 300
		Hospedagem hospedagem2= criarHospedagemModelo();// nome do hospede modelo � Lucinete e o cpf � 23
		hospedagem2.setDataEntrada(formatador.parse("24/04/2012"));
		hospedagem2.setDataSaida(formatador.parse("27/04/2012"));
		fachada.realizarHospedagem(hospedagem2);
		fachada.fechaConta("23", formatador.parse("27/04/2012"));// Encerrou a 2 hospedagem
		//ter�eira hospedagem, s� hospedagem(d�aria) 28/04 at� 02/05 total r$ 400
		Hospedagem hospedagem3= criarHospedagemModelo();// nome do hospede modelo � Lucinete e o cpf � 23
		hospedagem3.setDataEntrada(formatador.parse("28/04/2012"));
		hospedagem3.setDataSaida(formatador.parse("02/05/2012"));
		fachada.realizarHospedagem(hospedagem3);
		fachada.fechaConta("23", formatador.parse("02/05/2012"));// Encerrou a ter�eira hospedagem
		Hospede h= fachada.consultarHospede("23");//testar o hist�rico de hospedagem
		Assert.assertEquals(h.getNome(),"Lucinete");//Hospede modelo que foi cadastrado
		Assert.assertEquals(h.getHistorico().size(), 3);//Esse hospede teve tr�s hospedagem
		Assert.assertEquals(h.getHistorico().get(0).getQuarto().getTipoDeQuarto(),"B�sico");//primeira hospedagem  seu quarto era basico(correto)
		Assert.assertEquals(h.getHistorico().get(0).getListaDeComsumo().size(),2);//primeira hospedagem o numero de consumio foi 2 produtos
		Assert.assertEquals(h.getHistorico().get(0).getListaDeComsumo().get(0).getDescricao(),"Vinho Tinto Seco");//Um desses produtos era um vinho!
		Assert.assertEquals(h.getHistorico().get(0).getValorfinal(),590.0);// Valor final pago, somando tudo(diarias, consumos) da primeira hospedagem!!!
		Assert.assertEquals(h.getHistorico().get(1).getDataEntrada(),formatador.parse("24/04/2012"));// testa segunta hospedagem a data de entrada
		Assert.assertEquals(h.getHistorico().get(1).getValorfinal(),300.0);// testa o valor final da segunda hospedagem
		Assert.assertEquals(h.getHistorico().get(2).getDataSaida(),formatador.parse("02/05/2012"));// testa ter�eira hospedagem a data de saida
		Assert.assertEquals(h.getHistorico().get(2).getValorfinal(),400.0);// testa o valor final da ter�eira hospedagem
	}
	
	@Test
	public void TestPersistenciaSimples() throws ParseException{
		Hospedagem hospedagem1= criarHospedagemModelo();// nome do hospede nessa hospedagem Lucinete cpf 23
		fachada.realizarHospedagem(hospedagem1);
		fachada=new Fachada();
		Assert.assertEquals(hospedagem1.getHospede(), fachada.consultaHospedagem("23").getHospede());
	}
	
	@Test(expected=Excecao.class)
	public void TestPersistenciaCompleta() throws ParseException{
		Hospedagem hospedagem1= criarHospedagemModelo();// nome do hospede nessa hospedagem Lucinete cpf 23
		fachada.realizarHospedagem(hospedagem1);
		Consumo c=criarConsumo();
		fachada.adicionarConsumo(05, c);// consumo a hospedagem: vinho R$ 80,00

		Reserva reserva1= criarReservaModelo();//Reserva com cliente de cpf 23
		reserva1.setDataEntrada(formatador.parse("24/04/2012"));//Alterar as data da reserva pq iria dar choque com a hospedagem realizada acima, pois quarto e os dias s�o iquaias
		reserva1.setDataSaida(formatador.parse("27/04/2012"));
		fachada.realizarReserva(reserva1);
		fachada=new Fachada();//testa se as altera��es foram salvas
		Assert.assertEquals(hospedagem1.getHospede(), fachada.consultaHospedagem("23").getHospede());//hospedagem existe
		Assert.assertEquals(hospedagem1.getListaDeComsumo().size(), fachada.consultaHospedagem("23").getListaDeComsumo().size());
		Assert.assertEquals(hospedagem1.getListaDeComsumo().get(0), fachada.consultaHospedagem("23").getListaDeComsumo().get(0));//o consumo feito na hospedagem existe, vinho R$ 80,00
		Assert.assertEquals(reserva1.getHospede(), fachada.consultaReserva("23").getHospede());//reserva existe
		
		fachada.fechaConta("23", formatador.parse("23/04/2012"));//Encerrou a hospedagem
		fachada=new Fachada();//testa se essa altera��o foi salva
		Assert.assertEquals(reserva1.getHospede(), fachada.consultaReserva("23").getHospede());//reserva ainda existe, feita no inicio
		Assert.assertEquals(fachada.consultarHistorico("23").size(), 1);// Existe um hospede cadastrado e que j� tem uma hospedagem em seu hist�rico
		Assert.assertEquals(fachada.consultarHistorico("23").get(0).getValorfinal(), 580.00);
		fachada.consultaHospedagem("23");// exce��o, hospedagem n�o existe mais, foi encerrada no programa anterior(antes do new fachada), agora esta hospedagem constar no historico desse hospede, verificado nos teste acima
		
		
	}
	
	
	private Hospedagem criarHospedagemModelo() throws ParseException{
		Hospedagem h=new Hospedagem();
		
		Quarto q = criarQuarto();
		Hospede hos = criarHospede();
		GerentePersistencia.getInstance().getListaQuarto().add(q);
		GerentePersistencia.getInstance().getListaHospedes().add(hos);
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
		q.setTipoDeQuarto("B�sico");
		q.setDescricao("Televis�o, frigobar, ventilador, sem terra�o!!!");
		q.setValor(100.00);
		return q;
	}
	
	private Consumo criarConsumo(){
		Consumo c=new Consumo();
		c.setDescricao("Vinho Tinto Seco");
		c.setValorConsumo(80.0);
		return c;
	}
	
}