package recep��o;

import java.util.Date;
import java.util.List;

public class fachada {
	private GerenteHospede gerenteHospede;
	private GerenteFuncionario gerenteFuncionario;
	private GerenteHotel gerenteHotel;
	private GerenteHospedagem gerenteHospegem;
	
	public fachada(){
		this.gerenteHospede = new GerenteHospede();
		this.gerenteFuncionario=new GerenteFuncionario();
		this.gerenteHotel=new GerenteHotel();
		this.gerenteHospegem= new GerenteHospedagem();
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Cadastra um funcion�rio no sistema.
	 */
	public void cadastroFuncionario(Funcionario f){
		
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Remove um funcion�rio do sistema.
	 */
	public Funcionario removerFuncionario(String cpf){
		return null;
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Consulta os dados de um funcion�rio.
	 */
	public Funcionario consultarFuncionario(String nome){
		return null;
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Informa uma lista com os funcion�rios atuais, mostrando nome, cpf, fun��o.
	 */
	public List<Funcionario> informaListaFuncionario(){
		return null;
	}
	
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Alterar dados de um funcion�rio, procura esse funcion�rio(com o mesmo cpf) na lista e sobrescreve com f.
	 */
	public void alterarDadosFuncionario(Funcionario f){
		
	}
	
	/*
	 * Responsabilidade gerenteHospede
	 * Cadastra um hospede no sistema.
	 */
	public void cadastroHospede(Hospede h){
		
	}
	
	/*
	 * Responsabilidade gerenteHospede
	 * Remove um hospede do sistema.
	 */
	public Hospede removerHospede(String cpf){
		return null;
	}
	
	/*
	 * Responsabilidade gerenteHospede
	 * Altera os dados do hospede cadastrado no sistema, procura esse hospede(com o mesmo cpf) na lista e sobrescreve com h.
	 */
	public void alterarDadosHospede(Hospede h){
		
	}

	/*
	 * Responsabilidade gerenteHospede
	 * Consulta hist�rico de hospedagem de um hospede.
	 */
	public void consultarHospede(String cpf){
		
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Cadastra um quarto no sistema.
	 */
	public void cadastraQuarto(Quarto q){
		
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * remover um quarto no sistema.
	 */
	public Quarto removerQuarto(int numero){
		return null;
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Altera a discri��o de um quarto no sistema
	 */
	public void alterarDiscricaoQuarto(String discri��o, int numero){
		
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Altera o pre�o de um quarto.
	 */
	public void alterarPrecoQuarto(int numero, double preco){
		
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Realiza uma reserva de um quarto no sistema.
	 */
	public void ralizarReserva(Reserva r){
		
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Realiza hospedagem!
	 */
	public void realizarHospedagem(Hospedagem h){
		
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Confere se um quarto esta vago.
	 */
	public boolean isQuartoVago(int numero, Date dataEntrada, Date dataSaida){
		return true;
	}
	
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Fecha conta total ou parcial.
	 */
	public double fechaConta(int numero, boolean fechaContaTotal){
		return 0.0;
	}
	/*
	 * Responsabilidade gerenteHospedagem
	 * Informa uma lista com todas as hospedagens de um determinado dia, informando quarto e o nome do hospede.
	 */
	public List<Hospedagem> informaListaHospedagemDia(Date dia){
		return null;
	}
	
}

