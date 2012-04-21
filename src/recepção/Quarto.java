package recepção;

public class Quarto {
	
	private int numero;
	private Double valor;
	private String descricao;
	private String TipoDeQuarto;
	
	public Quarto(){
		this.numero=0;
		this.TipoDeQuarto="";
		this.valor=0.0;
		this.descricao="Descrição do quarto";
		}
	
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

	public String getTipoDeQuarto() {
		return TipoDeQuarto;
	}

	public void setTipoDeQuarto(String tipoDeQuarto) {
		TipoDeQuarto = tipoDeQuarto;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String toString(){
		return "Numero: "+this.numero+" tipo de quarto: "+TipoDeQuarto+"\nValor: "+this.valor+" Descrição: "+this.descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((TipoDeQuarto == null) ? 0 : TipoDeQuarto.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + numero;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quarto other = (Quarto) obj;
		if (TipoDeQuarto == null) {
			if (other.TipoDeQuarto != null)
				return false;
		} else if (!TipoDeQuarto.equals(other.TipoDeQuarto))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (numero != other.numero)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
}
