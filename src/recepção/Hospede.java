package recepção;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Hospede {
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
	
	public String toString(){
		return p.toString();
	}
	public void setEmail(String email){
		p.setEmail(email);
	}
	public String getEmail(){
		return p.getEmail();
	}
	public void setTel(String tel){
		p.setEmail(tel);
	}
	public String getTel(){
		return p.getTel();
	}
}
