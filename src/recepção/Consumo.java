package recepção;

import java.io.Serializable;

public class Consumo implements Serializable{
	private Double valorConsumo;
	private String Descricao;
	private boolean pago;
	public Consumo(){
		valorConsumo=0.0;
		Descricao="";
		pago=false;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Descricao == null) ? 0 : Descricao.hashCode());
		result = prime * result + (pago ? 1231 : 1237);
		result = prime * result
				+ ((valorConsumo == null) ? 0 : valorConsumo.hashCode());
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
		Consumo other = (Consumo) obj;
		if (Descricao == null) {
			if (other.Descricao != null)
				return false;
		} else if (!Descricao.equals(other.Descricao))
			return false;
		if (pago != other.pago)
			return false;
		if (valorConsumo == null) {
			if (other.valorConsumo != null)
				return false;
		} else if (!valorConsumo.equals(other.valorConsumo))
			return false;
		return true;
	}
	
}
