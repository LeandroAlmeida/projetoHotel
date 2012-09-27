package recepcao;

import java.io.Serializable;
import java.util.Date;

public class Reserva extends Estadia implements Serializable{
	
	boolean Confirmacao;
	
	
	Reserva(){
		Confirmacao=false;
	}

	public void setConfirmacao() {
		Confirmacao = true;
	}
	
	
	public String getTipoEstadia(){
		return "Reserva";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (Confirmacao ? 1231 : 1237);
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
		Reserva other = (Reserva) obj;
		if (Confirmacao != other.Confirmacao)
			return false;
		return true;
	}
	
}
