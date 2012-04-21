package recepção;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class GerenteHospedagem {
	LinkedList<Estadia> listaDeEstadia;
	
	public GerenteHospedagem(){
		listaDeEstadia=new LinkedList<Estadia>();
	}
	
	public void realizarHospegagem(Hospedagem h) {
		if(isQuartoVago(h.getQuarto().getNumero(),h.getDataEntrada(),h.getDataSaida())){
			listaDeEstadia.add(h);
		}
		else
			throw new Excecao("Quarto já ocupado neste período de tempo!!!");		
	}
	
	
	public void realizarReserva(Reserva r) {
		if(isQuartoVago(r.getQuarto().getNumero(),r.getDataEntrada(),r.getDataSaida())){
			listaDeEstadia.add(r);
		}
		else
			throw new Excecao("Quarto já ocupado neste período de tempo!!!");	
	}
	
	public Reserva cancelarReserva(String Cpf){
		Reserva reservaRemovida;
		for(Estadia e:this.listaDeEstadia)
			if(e.getHospede().getCpf().equals(Cpf) && e.getTipoEstadia().equals("Reserva")){
				reservaRemovida=(Reserva) e;
				listaDeEstadia.remove(e);
				return reservaRemovida;
		}
			throw new Excecao("Não existe reserva com esse Cpf!!!");	
	}
	
	public void confirmarReserva(String Cpf){
		boolean aux=false;
		for(Estadia e:this.listaDeEstadia)
			if(e.getHospede().getCpf().equals(Cpf) && e.getTipoEstadia().equals("Reserva")){
				Hospedagem h=new Hospedagem();
				h.setDataEntrada(e.getDataEntrada());
				h.setDataSaida(e.getDataSaida());
				h.setHospede(e.getHospede());
				h.setQuarto(e.getQuarto());
				listaDeEstadia.remove(e);
				listaDeEstadia.add(h);
				aux=true;
			}
		if(aux==false)
			throw new Excecao("Não existe reserva com esse Cpf!!!");
	}
	
	public Reserva consultarReserva(String cpf){
		for(Estadia e:this.listaDeEstadia)
			if(e.getHospede().getCpf().equals(cpf) && e.getTipoEstadia().equals("Reserva")){
				return (Reserva)e;
			}
		throw new Excecao("Não existe reserva com esse Cpf!!!");
		
	}
	public Hospedagem consultarHospedagem(String cpf){
		for(Estadia e:this.listaDeEstadia)
			if(e.getHospede().getCpf().equals(cpf) && e.getTipoEstadia().equals("Hospedagem")){
				return (Hospedagem)e;
			}
		throw new Excecao("Não existe hospedagem com esse Cpf!!!");
		
	}
	
	public double fechaConta(String cpf, boolean fechaContaTotal) throws ParseException{
		double valor=0.0;
		Hospedagem hospedagem=null;
		for(Estadia e:this.listaDeEstadia)
			if(e.getHospede().getCpf().equals(cpf) && e.getTipoEstadia().equals("Hospedagem")){//encontrar a hospedagem
				hospedagem=(Hospedagem) e;
				break;
			}
		if(hospedagem==null)
			throw new Excecao("Não existe hospedagem com esse Cpf!!!");
		
		LinkedList<Consumo> listaConsumo=hospedagem.getListaDeComsumo();
		for(Consumo c:listaConsumo)
			valor+=c.getValorConsumo();//vai somando o valor de cada item na lista de consumo
		
		if(fechaContaTotal){
		valor=hospedagem.getQuarto().getValor() * calcularDias(hospedagem.getDataEntrada(),new Date());//multiplica o valor do quarto pela quantidade dias de hospedagem
		listaDeEstadia.remove(hospedagem);
		}
		else{
			valor=hospedagem.getQuarto().getValor() * calcularDias(hospedagem.getDataEntrada(),new Date());//multiplicar o valor do quarto pela quantidade de dia(s) de hospedagem
			hospedagem.setDataEntrada(new Date());
		}
		
		return valor;
	}
	
	 public int calcularDias (Date inicio, Date fim) throws ParseException {  
	        return (int) ((fim.getTime() - inicio.getTime() + 3600000L) / 86400000L);  
	    }
	 
	
	public boolean isQuartoVago(int num, Date dataEntrada, Date dataSaida){
		for(Estadia e:this.listaDeEstadia){
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
		 for(Estadia e:this.listaDeEstadia)
				if(e.getTipoEstadia().equals("Hospedagem") && num==e.getQuarto().getNumero()){
					Hospedagem h= (Hospedagem) e;
					h.addConsumo(c);
					e=h;
				}
					
		}

	public LinkedList<Reserva> informaListaDeReservasPendentes(Date dia) {
		LinkedList<Reserva> lista=new LinkedList<Reserva>();
		for(Estadia e:this.listaDeEstadia)
			if(e.getTipoEstadia().equals("Reserva") && (e.getDataEntrada().equals(dia)||e.getDataEntrada().after(dia)))
				lista.add((Reserva)e);
		return lista;
	}

}
