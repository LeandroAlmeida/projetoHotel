package recepcao;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

public class Hospedagem extends Estadia implements Serializable {
	
	
	LinkedList<Consumo> consumo;
	Double valorfinal=0.0;
	
	public Double getValorfinal() {
		return valorfinal;
	}

	public void setValorfinal(Double valorfinal) {
		this.valorfinal += valorfinal;
	}

	public Hospedagem(){
		consumo=new LinkedList<Consumo>();
	}

	public void addConsumo(Consumo c){
		consumo.add(c);
	}
	
	public LinkedList<Consumo> getListaDeComsumo(){
		return this.consumo;
	}
	
	public String getTipoEstadia(){
		return "Hospedagem";
	}
	
	public String toString(){
		return "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((consumo == null) ? 0 : consumo.hashCode());
		result = prime * result
				+ ((valorfinal == null) ? 0 : valorfinal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospedagem other = (Hospedagem) obj;
		if (consumo == null) {
			if (other.consumo != null)
				return false;
		} else if (!consumo.equals(other.consumo))
			return false;
		if (valorfinal == null) {
			if (other.valorfinal != null)
				return false;
		} else if (!valorfinal.equals(other.valorfinal))
			return false;
		return true;
	}


}
