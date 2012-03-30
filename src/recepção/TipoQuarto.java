package recepção;

public class TipoQuarto {
	private Double valor;
	private String descricao;
	private String nomeTipo;
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNomeTipo() {
		return nomeTipo;
	}
	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}
	
	public String toString(){
		return "\nO valor é: "+this.valor+"\nDescrição: "+descricao+"\nTipo de quarto: "+this.descricao;
	}
	
}
