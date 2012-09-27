package recepcao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class GerenteHospedagem {
	//ListaDeEstadia;
	
	public void realizarHospegagem(Hospedagem h) {
		if(isQuartoVago(h.getQuarto().getNumero(),h.getDataEntrada(),h.getDataSaida())){
			GerentePersistencia.getInstance().getListaDeEstadia().add(h);
			GerentePersistencia.persistir();
		}
		else
			throw new Excecao("Quarto já ocupado neste período de tempo!!!");		
	}
	
	
	public void realizarReserva(Reserva r) {
		if(isQuartoVago(r.getQuarto().getNumero(),r.getDataEntrada(),r.getDataSaida())){
			GerentePersistencia.getInstance().getListaDeEstadia().add(r);
			GerentePersistencia.persistir();
		}
		else
			throw new Excecao("Quarto já ocupado neste período de tempo!!!");	
	}
	
	public Reserva cancelarReserva(String Cpf){
		Reserva reservaRemovida;
		for(Estadia e:GerentePersistencia.getInstance().getListaDeEstadia())
			if(e.getHospede().getCpf().equals(Cpf) && e.getTipoEstadia().equals("Reserva")){
				reservaRemovida=(Reserva) e;
				GerentePersistencia.getInstance().getListaDeEstadia().remove(e);
				GerentePersistencia.persistir();
				return reservaRemovida;
		}
			throw new Excecao("Não existe reserva com esse Cpf!!!");	
	}
	
	public void confirmarReserva(String Cpf){
		boolean aux=false;
		for(Estadia e:GerentePersistencia.getInstance().getListaDeEstadia())
			if(e.getHospede().getCpf().equals(Cpf) && e.getTipoEstadia().equals("Reserva")){
				Hospedagem h=new Hospedagem();
				h.setDataEntrada(e.getDataEntrada());
				h.setDataSaida(e.getDataSaida());
				h.setHospede(e.getHospede());
				h.setQuarto(e.getQuarto());
				GerentePersistencia.getInstance().getListaDeEstadia().remove(e);
				GerentePersistencia.getInstance().getListaDeEstadia().add(h);
				GerentePersistencia.persistir();
				aux=true;
			}
		if(aux==false)
			throw new Excecao("Não existe reserva com esse Cpf!!!");
	}
	
	public Reserva consultarReserva(String cpf){
		for(Estadia e:GerentePersistencia.getInstance().getListaDeEstadia())
			if(e.getHospede().getCpf().equals(cpf) && e.getTipoEstadia().equals("Reserva")){
				return (Reserva)e;
			}
		throw new Excecao("Não existe reserva com esse Cpf!!!");
		
	}
	public Hospedagem consultarHospedagem(String cpf){
		for(Estadia e:GerentePersistencia.getInstance().getListaDeEstadia())
			if(e.getHospede().getCpf().equals(cpf) && e.getTipoEstadia().equals("Hospedagem")){
				return (Hospedagem)e;
			}
		throw new Excecao("Não existe hospedagem com esse Cpf!!!");
		
	}
	
	public double fechaConta(String cpf, Date dia) throws ParseException{
		double valor=0.0;
		Hospedagem hospedagem=null;
		for(Estadia e:GerentePersistencia.getInstance().getListaDeEstadia())
			if(e.getHospede().getCpf().equals(cpf) && e.getTipoEstadia().equals("Hospedagem")){//encontrar a hospedagem
				hospedagem=(Hospedagem) e;
				break;
			}
		if(hospedagem==null)
			throw new Excecao("Não existe hospedagem com esse Cpf!!!");
		
		
		for(Consumo c:hospedagem.getListaDeComsumo()){
			if(c.isPago()==false){
				valor+=c.getValorConsumo();//vai somando o valor de cada item da lista de consumo
				c.setPago(true);
			}
		}
		
		if(hospedagem.getDataSaida().equals(dia)){
			valor+=hospedagem.getQuarto().getValor() * calcularDias(hospedagem.getDataPrimeiroDiaNaoPago(),dia);//multiplica o valor do quarto pela quantidade dias de hospedagem
			for (Hospede h : GerentePersistencia.getInstance().getListaHospedes()) 
				if (h.getCpf().equals(cpf)) 
					h.addHistoricoHospedagem(hospedagem);
			hospedagem.setValorfinal(valor);	
			GerentePersistencia.getInstance().getListaDeEstadia().remove(hospedagem);
		}
		else{
			valor+=hospedagem.getQuarto().getValor() * calcularDias(hospedagem.getDataPrimeiroDiaNaoPago(),dia);//multiplica o valor do quarto pela quantidade de dias de hospedagem
			hospedagem.setDataPrimeiroDiaNaoPago(dia);
			hospedagem.setValorfinal(valor);
		}
		GerentePersistencia.persistir();
		return valor;
	}
	
	 public int calcularDias (Date inicio, Date fim) throws ParseException {  
	        return (int) ((fim.getTime() - inicio.getTime() + 3600000L) / 86400000L);  
	    }
	 
	
	public boolean isQuartoVago(int num, Date dataEntrada, Date dataSaida){
		for(Estadia e:GerentePersistencia.getInstance().getListaDeEstadia()){
			if(comparacao(e,num,dataEntrada,dataSaida)==false)
				return false;
		}
		return true;
	}
	
	private boolean comparacao(Estadia e, int num, Date dataEntrada, Date dataSaida){
		Date HospJaExistenteEntrada = e.getDataEntrada();
		Date HospJaExistenteSaida = e.getDataSaida();
		int numero=e.getQuarto().getNumero();
		
		if(dataEntrada.before(HospJaExistenteEntrada) && dataSaida.after(HospJaExistenteSaida) && num==numero)
			return false;
		else if((dataEntrada.equals(HospJaExistenteEntrada) || dataEntrada.after(HospJaExistenteEntrada)) && (dataEntrada.equals(HospJaExistenteSaida) || dataEntrada.before(HospJaExistenteSaida)) && num==numero)
			return false;
		else if((dataSaida.equals(HospJaExistenteEntrada) || dataSaida.after(HospJaExistenteEntrada)) && (dataSaida.equals(HospJaExistenteSaida) || dataSaida.before(HospJaExistenteSaida)) && num==numero)
			return false;
		else
		return true;
	}

	 public void addConsumoHospedagem(int num,Consumo c) {
		 boolean aux=false;
		 for(Estadia e:GerentePersistencia.getInstance().getListaDeEstadia())
				if(e.getTipoEstadia().equals("Hospedagem") && num == e.getQuarto().getNumero()){
					Hospedagem h= (Hospedagem) e;
					h.addConsumo(c);
					GerentePersistencia.persistir();
					aux=true;
				}
		 if(aux==false)
			 throw new Excecao("Não pode adicionar consumo a um quarto vago!!!");
					
		}

	public LinkedList<Reserva> informaListaDeReservasPendentes(Date dia) {
		LinkedList<Reserva> lista=new LinkedList<Reserva>();
		for(Estadia e:GerentePersistencia.getInstance().getListaDeEstadia())
			if(e.getTipoEstadia().equals("Reserva") && (e.getDataEntrada().equals(dia)||e.getDataEntrada().after(dia)))
				lista.add((Reserva)e);
		return lista;
	}
	
	public LinkedList<Hospedagem> informaListaHospedagemEncerraNesteDia(Date dia) {
		LinkedList<Hospedagem> lista=new LinkedList<Hospedagem>();
		for(Estadia e:GerentePersistencia.getInstance().getListaDeEstadia())
			if(e.getTipoEstadia().equals("Hospedagem") && e.getDataSaida().equals(dia))
				lista.add((Hospedagem)e);
		return lista;
	}
	
}
