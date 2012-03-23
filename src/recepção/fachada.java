package recepção;

public class fachada {
	private GerenteHospede gerenteHospede;
	private GerenteFuncionario gerenteFuncionario;
	private GerenteHotel gerenteHotel;
	private GerenteHospedagem gerenteHospegem;
	
	public fachada(){
		this.gerenteHospede = new GerenteHospede();
		this.gerenteFuncionario=new GerenteFuncionario();
		this.gerenteHotel=new gerenteHotel();
		this.gerenteHospegem= new GerenteHospedagem();
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Cadastra um funcionário no sistema.
	 */
	public void cadastroFuncionario(){
		
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Remove um funcionário do sistema.
	 */
	public void removerFuncionario(){
		
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Consulta os dados de um funcionário.
	 */
	public void consultarFuncionario(){
		
	}
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Informa uma lista com os funcionários atuais, mostrando nome, cpf, função.
	 */
	public void informaListaFuncionario(){
		
	}
	
	
	/*
	 * Responsabilidade gerenteFuncionario
	 * Alterar dados de um funcionário.
	 */
	public void alterarDadosFuncionario(){
		
	}
	
	/*
	 * Responsabilidade gerenteHospede
	 * Cadastra um hospede no sistema.
	 */
	public void cadastroHospede(){
		
	}
	
	/*
	 * Responsabilidade gerenteHospede
	 * Remove um hospede do sistema.
	 */
	public void removerHospede(){
		
	}
	
	/*
	 * Responsabilidade gerenteHospede
	 * Altera os dados do hospede cadastrado no sistema.
	 */
	public void alterarDadosHospede(){
		
	}

	/*
	 * Responsabilidade gerenteHospede
	 * Consulta histórico de hospedagem de um hospede.
	 */
	public void consultarHospede(){
		
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Cadastra um quarto no sistema.
	 */
	public void cadastraQuarto(){
		
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * remover um quarto no sistema.
	 */
	public void removerQuarto(){
		
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Altera a discrição de um quarto no sistema
	 */
	public void alterarDiscriçãoQuarto(){
		
	}
	
	/*
	 * Responsabilidade gerenteHotel
	 * Altera o preço de um quarto.
	 */
	public void alterarPrecoQuarto(){
		
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Realiza uma reserva de um quarto no sistema.
	 */
	public void ralizarReserva(){
		
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Realiza hospedagem!
	 */
	public void realizarHospedagem(){
		
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Confere se um quarto esta vago.
	 */
	public void isQuartoVago(){
		
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Fecha conta parcial.
	 */
	public void fechaContaParcial(){
		
	}
	
	/*
	 * Responsabilidade gerenteHospedagem
	 * Fecha conta total, ou seja, o hospede encerra sua hospedagem.
	 */
	public void fechaConta(){
		
	}
	/*
	 * Responsabilidade gerenteHospedagem
	 * Informa uma lista com todas as hospedagens de um determinado dia, informando quarto e o nome do hospede.
	 */
	public void informaListaHospedagemDia(){
		
	}
	
}

