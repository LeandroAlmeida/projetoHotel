package recep��o;

import java.util.LinkedList;
import java.util.List;

public class GerenteHotelQuarto {
	//private LinkedList<Quarto> listaQuarto;
	
	
	public void cadastraQuarto(Quarto q){
		for(Quarto q2: GerentePersistencia.getInstance().getListaQuarto()){
			if(q2.getNumero()==q.getNumero())
				throw new Excecao("N�mero de quarto j� cadastrado!!!");
		}
		GerentePersistencia.getInstance().getListaQuarto().add(q);
		GerentePersistencia.persistir();
	}
	
	public Quarto removerQuarto(int numero){
		Quarto quartoRemovido;
		for(Quarto q: GerentePersistencia.getInstance().getListaQuarto()){
			if(q.getNumero()==numero){
				quartoRemovido=q;
				 GerentePersistencia.getInstance().getListaQuarto().remove(q);
				 GerentePersistencia.persistir();
				return quartoRemovido;
			}
		}
		throw new Excecao("Quarto solicitado n�o existe!!!");
	}
	
	public void alterarDescricaoQuarto(String descri��o, String tipoDeQuarto){
		for(Quarto q: GerentePersistencia.getInstance().getListaQuarto()){
			if(q.getTipoDeQuarto().equals(tipoDeQuarto)){
				q.setDescricao(descri��o);
				GerentePersistencia.persistir();
			}
		}
	}
	
	public void alterarPrecoQuarto(String tipoDeQuarto, double preco){
		for(Quarto q: GerentePersistencia.getInstance().getListaQuarto()){
			if(q.getTipoDeQuarto().equals(tipoDeQuarto)){
				q.setValor(preco);
				GerentePersistencia.persistir();
			}
		}
	}


	public Quarto getQuarto(int num) {
		for(Quarto q: GerentePersistencia.getInstance().getListaQuarto()){
			if(q.getNumero()==num)
				return q;
		}
		throw new Excecao("Quarto solicitado n�o existe!!!");
	}


	public List<Quarto> listaDeQuartoAtual() {
		return GerentePersistencia.getInstance().getListaQuarto();
	}

}
