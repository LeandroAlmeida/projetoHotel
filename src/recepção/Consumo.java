package recepção;

public class Consumo {
	private Double valorConsumo;
	private String Descricao;
	
	public Consumo(){
		valorConsumo=0.0;
		Descricao="";
	}

	public Double getValorConsumo() {
		return valorConsumo;
	}

	public void setValorConsumo(Double valorConsumo) {
		this.valorConsumo = valorConsumo;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	public String toString(){
		return "Descrição: \n"+this.Descricao+"\nValor: "+this.valorConsumo;
	}
	
}
