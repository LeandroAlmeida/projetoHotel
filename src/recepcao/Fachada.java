package recepcao;

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
		GerentePersistencia.recuperar();
		this.gerenteHospede = new GerenteHospede();
		this.gerenteFuncionario=new GerenteFuncionario();
		this.gerenteHotel=new GerenteHotelQuarto();
		this.gerenteHospedagem= new GerenteHospedagem();	
		
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Cadastrar um funcion�rio no sistema.
	 */
	public void cadastroFuncionario(Funcionario f){
		gerenteFuncionario.cadastroFuncionario(f);
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Remover um funcion�rio do sistema.
	 */
	public Funcionario removerFuncionario(String cpf){
		return gerenteFuncionario.removerFuncionario(cpf);
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Consultar os dados de um funcion�rio.
	 */
	public Funcionario consultarFuncionario(String cpf){
		return gerenteFuncionario.consultarFuncionario(cpf);
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Informar uma lista com os funcion�rios atuais, mostrando nome, cpf, fun��o.
	 */
	public List<Funcionario> informaListaFuncionario(){
		return gerenteFuncionario.informaListaFuncionario();
	}
	
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Alterar dados de um funcion�rio, procura esse funcion�rio(com o mesmo cpf) na lista e sobrescreve com f.
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
	 * Altera a descri��o de um tipo de quarto no sistema, exemplo: altera a descri��o de todos quartos do tipo b�sico.
	 */
	public void alterarDescricaoQuarto(String descri��o, String tipoDeQuarto){
		gerenteHotel.alterarDescricaoQuarto(descri��o, tipoDeQuarto);
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Altera o pre�o de um tipo de quarto no sistema,  exemplo: altera a pre�o de todos quartos do tipo b�sico.
	 */
	public void alterarPrecoQuarto(double preco,String tipoDeQuarto){
		gerenteHotel.alterarPrecoQuarto(tipoDeQuarto, preco);
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Retorna as informa��es do quarto de um determinado n�mero
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
	 * Confirma uma reserva no sistema, ao confirmar os dados dessa reserva passa para uma hospedagem e ela � removida.
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
	 * Conferir se um quarto est� vago.
	 */
	public boolean isQuartoVago(int numero, Date dataEntrada, Date dataSaida){
		return gerenteHospedagem.isQuartoVago(numero,dataEntrada,dataSaida);
	}
	
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Fecha conta total ou parcial.
	 */
	public double fechaConta(String cpf, Date dia) throws ParseException{
		return gerenteHospedagem.fechaConta(cpf, dia);
	}
	/*
	 * Responsabilidade gerenteHospedagem
	 * Informa uma lista com todas as reservas de um dia ou dias anteriores, podendo assim, remover essas reservas que n�o se 
	 * tornaram hospedagem.
	 */
	public LinkedList<Reserva> informaListaReservasPendentes(Date dia){
		return gerenteHospedagem.informaListaDeReservasPendentes(dia);
	}
	/*
	 * Responsabilidade gerenteHospedagem
	 * Informa uma lista com todas as hospedagens que encerr�o neste dia.
	 */
	public LinkedList<Hospedagem> informaListaHospedagemEncerraNesteDia(Date dia){
		return gerenteHospedagem.informaListaHospedagemEncerraNesteDia(dia);
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Adicionar um consumo a uma hospedagem, atrav�s do numero do quarto
	 */
	public void adicionarConsumo(int numero, Consumo c){
		gerenteHospedagem.addConsumoHospedagem(numero,c);
	}
}

