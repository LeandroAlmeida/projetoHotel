package recepção;

import java.util.LinkedList;
import java.util.List;

public class GerenteHotelQuarto {
	private LinkedList<Quarto> listaQuarto;
	
	public GerenteHotelQuarto(){
		listaQuarto=new LinkedList<Quarto>();
	}
	
	
	public void cadastraQuarto(Quarto q){
		for(Quarto q2: this.listaQuarto){
			if(q2.getNumero()==q.getNumero())
				throw new Excecao("Numero de quarte já cadastrado!!!");
		}
		listaQuarto.add(q);
	}
	
	public Quarto removerQuarto(int numero){
		Quarto quartoRemovido;
		for(Quarto q: this.listaQuarto){
			if(q.getNumero()==numero){
				quartoRemovido=q;
				listaQuarto.remove(q);
				return quartoRemovido;
			}
		}
		throw new Excecao("Quarto solicitado não existe!!!");
	}
	
	public void alterarDescricaoQuarto(String descrição, String tipoDeQuarto){
		for(Quarto q: this.listaQuarto){
			if(q.getTipoDeQuarto().equals(tipoDeQuarto))
				q.setDescricao(descrição);
		}
	}
	
	public void alterarPrecoQuarto(String tipoDeQuarto, double preco){
		for(Quarto q: this.listaQuarto){
			if(q.getTipoDeQuarto().equals(tipoDeQuarto))
				q.setValor(preco);
		}
	}


	public Quarto getQuarto(int num) {
		for(Quarto q: this.listaQuarto){
			if(q.getNumero()==num)
				return q;
		}
		throw new Excecao("Quarto solicitado não existe!!!");
	}


	public List<Quarto> listaDeQuartoAtual() {
		return this.listaQuarto;
	}

}
