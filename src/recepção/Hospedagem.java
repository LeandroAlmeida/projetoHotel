package recepção;

import java.util.Date;
import java.util.LinkedList;

public class Hospedagem extends Estadia{
	
	LinkedList<Consumo> consumo;
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
		return true;
	}
	
}
