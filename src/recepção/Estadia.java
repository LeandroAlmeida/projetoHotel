package recepção;

import java.io.Serializable;
import java.util.Date;

public abstract class Estadia implements Serializable {
	private Date dataEntrada;
	private Date dataSaida;
	private Quarto quarto;
	private Hospede hospede;
	private Date dataPrimeiroDiaNaoPago;
	public Hospede getHospede() {
		return hospede;
	}
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
		this.dataPrimeiroDiaNaoPago=dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public Date getDataPrimeiroDiaNaoPago() {
		return dataPrimeiroDiaNaoPago;
	}

	public void setDataPrimeiroDiaNaoPago(Date dataDiaNaoPago) {
		this.dataPrimeiroDiaNaoPago = dataDiaNaoPago;
	}
	
	public abstract String getTipoEstadia();
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataEntrada == null) ? 0 : dataEntrada.hashCode());
		result = prime
				* result
				+ ((dataPrimeiroDiaNaoPago == null) ? 0
						: dataPrimeiroDiaNaoPago.hashCode());
		result = prime * result
				+ ((dataSaida == null) ? 0 : dataSaida.hashCode());
		result = prime * result + ((hospede == null) ? 0 : hospede.hashCode());
		result = prime * result + ((quarto == null) ? 0 : quarto.hashCode());
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
		Estadia other = (Estadia) obj;
		if (dataEntrada == null) {
			if (other.dataEntrada != null)
				return false;
		} else if (!dataEntrada.equals(other.dataEntrada))
			return false;
		if (dataPrimeiroDiaNaoPago == null) {
			if (other.dataPrimeiroDiaNaoPago != null)
				return false;
		} else if (!dataPrimeiroDiaNaoPago.equals(other.dataPrimeiroDiaNaoPago))
			return false;
		if (dataSaida == null) {
			if (other.dataSaida != null)
				return false;
		} else if (!dataSaida.equals(other.dataSaida))
			return false;
		if (hospede == null) {
			if (other.hospede != null)
				return false;
		} else if (!hospede.equals(other.hospede))
			return false;
		if (quarto == null) {
			if (other.quarto != null)
				return false;
		} else if (!quarto.equals(other.quarto))
			return false;
		return true;
	}
	
	
}
