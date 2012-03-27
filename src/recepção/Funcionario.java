package recepção;

import java.util.Date;

public class Funcionario {
	
	private String profissao;
	private Pessoa p;
	
	public Funcionario(){
		this.profissao="";
		p=new Pessoa();
	}

	public String getNome() {
		 return p.getNome();
	}

	public void setNome(String nome) {
		p.setNome(nome);
	}

	public Date getDataNacimento() {
		return p.getDataNacimento();
	}

	public void setDataNacimento(Date dataNacimento) {
		p.setDataNacimento(dataNacimento);
	}

	public String getCpf() {
		return p.getCpf();
	}

	public void setCpf(String cpf) {
		p.setCpf(cpf);
	}
	
	public String getRg() {
		return p.getRg();
	}

	public void setRg(String rg) {
		p.setRg(rg);
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String proficao) {
		this.profissao = proficao;
	}

	
	public String toString(){
		return p.toString()+"\nprofissão: "+this.profissao;
	}
}
