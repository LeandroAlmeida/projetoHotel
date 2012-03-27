package recepção;

import java.util.Date;

public class Pessoa {
	private String nome;
	private Date dataNacimento;
	private String cpf;
	private String rg;
	
	public Pessoa(){
		this.nome="sem nome";
		this.dataNacimento=null;
		this.cpf="";
		this.rg="";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(Date dataNacimento) {
		this.dataNacimento = dataNacimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	public String toString(){
		return "nome é: "+this.nome+"\ndata de nascimento: "+this.dataNacimento+"\ncpf: "+this.cpf+"\nrg: "+this.rg+"\nprofição: ";
	}
}
