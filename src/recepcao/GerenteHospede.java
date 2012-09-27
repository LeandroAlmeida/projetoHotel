package recepcao;

import java.util.LinkedList;
import java.util.List;

public class GerenteHospede {

	//public LinkedList<Hospede> listaHospedes;

	public void cadastrarHospede(Hospede h) {
		for(Hospede hos:GerentePersistencia.getInstance().getListaHospedes()){
			if(hos.getCpf().equals(h.getCpf()))
				throw new Excecao("Cpf já cadastrado!!!");
		}
		GerentePersistencia.getInstance().getListaHospedes().add(h);
		GerentePersistencia.persistir();
	}

	public Hospede removerHospede(String cpf) {
		Hospede HospedeRemovido;
		for (Hospede h : GerentePersistencia.getInstance().getListaHospedes()) {
			if (h.getCpf().equals(cpf)) {
				GerentePersistencia.getInstance().getListaHospedes().remove(h);
				GerentePersistencia.persistir();
				HospedeRemovido = h;
				return HospedeRemovido;
			}
		}
		throw new Excecao("Hóspede não existente!!!");
	}

	public Hospede consultarHospede(String cpf) {
		
		for (Hospede h : GerentePersistencia.getInstance().getListaHospedes()) {
			if (h.getCpf().equals(cpf))
				return h;
		}
		throw new Excecao("Hóspede não existente!!!");

	}


	public Hospede alterarDadosHospede(Hospede hos){
			for (Hospede h : GerentePersistencia.getInstance().getListaHospedes()) {
					if(hos.getCpf().equals(h.getCpf())){
						h=hos;
						GerentePersistencia.persistir();
					return h;
					}
				}
			throw new Excecao("Hóspede não existente!!!");
	}
	
	public List<Hospedagem> consultarHistorico(String cpf) {
		for (Hospede h : GerentePersistencia.getInstance().getListaHospedes()) {
			if (h.getCpf().equals(cpf)) {
				return h.getHistorico();
			}
		}
		throw new Excecao("Hóspede não existente!!!");
	}
	
	
}
