package recepção;

import java.util.Date;
import java.util.LinkedList;

public class Hospedagem {
	private Date dataEntrada;
	private Date dataSaida;
	private Quarto quarto;
	LinkedList<Consumo> consumo;
	public Hospedagem(){
		dataEntrada=null;
		dataSaida=null;
		quarto=null;
		consumo=new LinkedList<Consumo>();
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
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
	
	
	
	public String toString(){
		return "data de Entrada: "+this.dataEntrada+"\nData de saida: "+this.dataSaida+"\n"+quarto.toString();
	}
}
