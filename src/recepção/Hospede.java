package recepção;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Hospede implements Serializable {
	private List<Hospedagem> historicoDeHospedagem;
	private Pessoa p;
	
	public Hospede(){
		historicoDeHospedagem=new LinkedList<Hospedagem>();
		p=new Pessoa();
	}
	
	public void addHistoricoHospedagem(Hospedagem h){
		historicoDeHospedagem.add(h);
	}
	
	public List<Hospedagem> getHistorico(){
		return historicoDeHospedagem;
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

	public void setDataNacimento(String dataNacimento) {
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
	
	public String toString(){
		return p.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((historicoDeHospedagem == null) ? 0 : historicoDeHospedagem
						.hashCode());
		result = prime * result + ((p == null) ? 0 : p.hashCode());
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
		Hospede other = (Hospede) obj;
		if (historicoDeHospedagem == null) {
			if (other.historicoDeHospedagem != null)
				return false;
		} else if (!historicoDeHospedagem.equals(other.historicoDeHospedagem))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}
	
	
}
