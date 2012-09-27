package recepção;

import java.io.Serializable;
import java.util.Date;

public class Pessoa implements Serializable {
	private String nome;
	private String dataNacimento;
	private String cpf;
	private String rg;
	private String Tel;
	private String email;
	
	public String getTel() {
		return this.Tel;
	}

	public void setTel(String tel) {
		this.Tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(String dataNacimento) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Tel == null) ? 0 : Tel.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataNacimento == null) ? 0 : dataNacimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (Tel == null) {
			if (other.Tel != null)
				return false;
		} else if (!Tel.equals(other.Tel))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNacimento == null) {
			if (other.dataNacimento != null)
				return false;
		} else if (!dataNacimento.equals(other.dataNacimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}


}
