package recepcao;

import java.io.Serializable;



public class Funcionario implements Serializable {
	
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

	public String getDataNacimento() {
		return p.getDataNacimento();
	}

	public void setDataNascimento(String dataNacimento) {
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

	public void setEmail(String email){
		p.setEmail(email);
	}
	public String getEmail(){
		return p.getEmail();
	}
	public void setTel(String tel){
		p.setTel(tel);
	}
	public String getTel(){
		return p.getTel();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result
				+ ((profissao == null) ? 0 : profissao.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (profissao == null) {
			if (other.profissao != null)
				return false;
		} else if (!profissao.equals(other.profissao))
			return false;
		return true;
	}
}
