package recepção;

import java.util.Date;
import java.util.List;

public class Fachada {
	private GerenteHospede gerenteHospede;
	private GerenteFuncionario gerenteFuncionario;
	private GerenteHotel gerenteHotel;
	private GerenteHospedagem gerenteHospegem;
	
	public Fachada(){
		this.gerenteHospede = new GerenteHospede();
		this.gerenteFuncionario=new GerenteFuncionario();
		this.gerenteHotel=new GerenteHotel();
		this.gerenteHospegem= new GerenteHospedagem();
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Cadastra um funcionário no sistema.
	 */
	public void cadastroFuncionario(Funcionario f){
		gerenteFuncionario.addFuncionario(f);
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Remove um funcionário do sistema.
	 */
	public Funcionario removerFuncionario(String cpf){
		return null;
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Consulta os dados de um funcionário.
	 */
	public Funcionario consultarFuncionario(String cpf){
		return gerenteFuncionario.consultaFuncionario(cpf);
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Informa uma lista com os funcionários atuais, mostrando nome, cpf, função.
	 */
	public List<Funcionario> informaListaFuncionario(){
		return null;
	}
	
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Alterar dados de um funcionário, procura esse funcionário(com o mesmo cpf) na lista e sobrescreve com f.
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
	 * Consulta histórico de hospedagem de um hospede.
	 */
	public Hospede consultarHospede(String cpf){
		return null;
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
	 * Altera a discrição de um quarto no sistema
	 */
	public void alterarDescricaoQuarto(String descrição, String tipoDeQuarto){
		
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Altera o preço de um quarto.
	 */
	public void alterarPrecoQuarto(String tipoDeQuarto, double preco){
		
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Realiza uma reserva de um quarto no sistema.
	 */
	public void realizarReserva(Reserva r){
		
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

