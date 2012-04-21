package recepção;

import java.util.LinkedList;
import java.util.List;

public class GerenteHospede {

	public LinkedList<Hospede> listaHospedes;

	public GerenteHospede() {

		this.listaHospedes = new LinkedList<Hospede>();

	}

	public void cadastrarHospede(Hospede h) {
		for(Hospede hos:this.listaHospedes){
			if(hos.getCpf().equals(h.getCpf()))
				throw new Excecao("Cpf ja cadastrado!!!");
		}
		this.listaHospedes.add(h);

	}

	public Hospede removerHospede(String cpf) {
		Hospede HospedeRemovido;
		for (Hospede h : this.listaHospedes) {
			if (h.getCpf().equals(cpf)) {
				this.listaHospedes.remove(h);
				HospedeRemovido = h;
				return HospedeRemovido;
			}
		}
		throw new Excecao("Hospede não existente!!!");
	}

	public Hospede consultarHospede(String cpf) {
		
		for (Hospede h : this.listaHospedes) {
			if (h.getCpf().equals(cpf))
				return h;
		}
		throw new Excecao("Hospede não existente!!!");

	}


	public Hospede alterarDadosHospede(Hospede hos){
			for (Hospede h : this.listaHospedes) {
					if(hos.getCpf().equals(h.getCpf())){
						h=hos;
					return h;
					}
				}
			throw new Excecao("Hospede não existente!!!");
	}
//falta essa funçao aqui e no teste, não esquece!!
	public List<Hospedagem> consultarHistorico(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
