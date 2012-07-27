package recepção;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;


public class Persistencia implements Serializable{
	
	private LinkedList<Hospede> listaHospedes;
	private LinkedList<Funcionario> listaFuncionarios;
	private LinkedList<Quarto> listaQuarto;
	private LinkedList<Estadia> listaDeEstadia;
	
	public Persistencia(){
		this.listaHospedes=new LinkedList<Hospede>();
		this.listaFuncionarios=new LinkedList<Funcionario>();
		this.listaQuarto=new LinkedList<Quarto>();
		this.listaDeEstadia=new LinkedList<Estadia>();
	}
	
	public LinkedList<Hospede> getListaHospedes() {
		return listaHospedes;
	}

	public LinkedList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public LinkedList<Quarto> getListaQuarto() {
		return listaQuarto;
	}

	public LinkedList<Estadia> getListaDeEstadia() {
		return listaDeEstadia;
	}

	

}