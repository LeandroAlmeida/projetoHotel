package recepção;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Fachada {
	private GerenteHospede gerenteHospede;
	private GerenteFuncionario gerenteFuncionario;
	private GerenteHotelQuarto gerenteHotel;
	private GerenteHospedagem gerenteHospedagem;

	
	public Fachada(){
	//	GerentePersistencia.recuperar();
		this.gerenteHospede = new GerenteHospede();
		this.gerenteFuncionario=new GerenteFuncionario();
		this.gerenteHotel=new GerenteHotelQuarto();
		this.gerenteHospedagem= new GerenteHospedagem();	
		
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Cadastrar um funcionário no sistema.
	 */
	public void cadastroFuncionario(Funcionario f){
		gerenteFuncionario.cadastroFuncionario(f);
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Remover um funcionário do sistema.
	 */
	public Funcionario removerFuncionario(String cpf){
		return gerenteFuncionario.removerFuncionario(cpf);
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Consultar os dados de um funcionário.
	 */
	public Funcionario consultarFuncionario(String cpf){
		return gerenteFuncionario.consultarFuncionario(cpf);
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Informar uma lista com os funcionários atuais, mostrando nome, cpf, função.
	 */
	public List<Funcionario> informaListaFuncionario(){
		return gerenteFuncionario.informaListaFuncionario();
	}
	
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Alterar dados de um funcionário, procura esse funcionário(com o mesmo cpf) na lista e sobrescreve com f.
	 */
	public Funcionario alterarDadosFuncionario(Funcionario f){
		return gerenteFuncionario.alterarDadosFuncionario(f);
	}
	
	/*
	 * Responsabilidade gerenteHospede
	 * Cadastra um hospede no sistema.
	 */
	public void cadastroHospede(Hospede h){
		gerenteHospede.cadastrarHospede(h);
	}
	
	/*
	 * Responsabilidade gerenteHospede
	 * Remove um hospede do sistema.
	 */
	public Hospede removerHospede(String cpf){
		return gerenteHospede.removerHospede(cpf);
	}
	
	/*
	 * Responsabilidade gerenteHospede
	 * Altera os dados do hospede cadastrado no sistema, procura esse hospede(com o mesmo cpf) na lista e sobrescreve com h.
	 */
	public void alterarDadosHospede(Hospede h){
		gerenteHospede.alterarDadosHospede(h);
	}

	/*
	 * Responsabilidade gerenteHospede
	 * Retorna o hospede com esse cpf.
	 */
	public Hospede consultarHospede(String cpf){
		return gerenteHospede.consultarHospede(cpf);
	}
	
	/*
	 * Retorna uma lista de hospedagem realizada por um hospede
	 */
	public List<Hospedagem> consultarHistorico(String cpf){
		return gerenteHospede.consultarHistorico(cpf);
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Cadastra um quarto no sistema.
	 */
	public void cadastraQuarto(Quarto q){
		gerenteHotel.cadastraQuarto(q);
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * remover um quarto no sistema.
	 */
	public Quarto removerQuarto(int numero){
		return gerenteHotel.removerQuarto(numero);
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Altera a descrição de um tipo de quarto no sistema, exemplo: altera a descrição de todos quartos do tipo básico.
	 */
	public void alterarDescricaoQuarto(String descrição, String tipoDeQuarto){
		gerenteHotel.alterarDescricaoQuarto(descrição, tipoDeQuarto);
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Altera o preço de um tipo de quarto no sistem,  exemplo: altera a preço de todos quartos do tipo básico.
	 */
	public void alterarPrecoQuarto(double preco,String tipoDeQuarto){
		gerenteHotel.alterarPrecoQuarto(tipoDeQuarto, preco);
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Retorna as informações do quarto de um determinado número
	 */
	public Quarto consultarInformacaoQuarto(int num){
		return gerenteHotel.getQuarto(num);
	}
	/*
	 * Responsabilidade gerenteHotel
	 * Retorna uma lista de quarto(s) atual do sistema.
	 */
	public List<Quarto> listaDeQuartoAtual(){
		return gerenteHotel.listaDeQuartoAtual();
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Realiza uma reserva de um quarto no sistema.
	 */
	public void realizarReserva(Reserva r){
		gerenteHospedagem.realizarReserva(r);
	}
	
	/*
	 * Cancelar uma reserva no sistema
	 */
	public Reserva cancelarReserva(String Cpf){
		return gerenteHospedagem.cancelarReserva(Cpf);
	}
	/*
	 * Confirma uma reserva no sistema, ao confirmar os dados dessa reserva passa para uma hospedagem e ela e removida
	 */
	public void confirmaReserva(String Cpf){
		gerenteHospedagem.confirmarReserva(Cpf);
	}
	/*
	 * Consulta uma reserva no sistema
	 */
	public Reserva consultaReserva(String cpf){
		return gerenteHospedagem.consultarReserva(cpf);
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Realizar hospedagem!
	 */
	public void realizarHospedagem(Hospedagem h){
		 gerenteHospedagem.realizarHospegagem(h);
	}
	
	/*
	 * Consultar uma hospedagem no sistema
	 */
	public Hospedagem consultaHospedagem(String cpf){
		return gerenteHospedagem.consultarHospedagem(cpf);
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Conferir se um quarto esta vago.
	 */
	public boolean isQuartoVago(int numero, Date dataEntrada, Date dataSaida){
		return gerenteHospedagem.isQuartoVago(numero,dataEntrada,dataSaida);
	}
	
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Fecha conta total ou parcial.
	 */
	public double fechaConta(String cpf, boolean fechaContaTotal) throws ParseException{
		return gerenteHospedagem.fechaConta(cpf, fechaContaTotal);
	}
	/*
	 * Responsabilidade gerenteHospedagem
	 * Informa uma lista com todas as reservas de um dia ou dias anteriores, podendo assim, remover essas reservas que não se 
	 * tornaram hospedagem.
	 */
	public LinkedList<Reserva> informaListaReservasPendentes(Date dia){
		return gerenteHospedagem.informaListaDeReservasPendentes(dia);
	}
	
	
	public void adicionarConsumo(int numero, Consumo c){
		gerenteHospedagem.addConsumoHospedagem(numero,c);
	}
}

