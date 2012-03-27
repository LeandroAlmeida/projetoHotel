package recepção;

public class Standap extends Quarto {
	
	public Standap(int numero){
		setValor(45.00);
		setNumero(numero);
		setDescricao("Quarto com ventilador, frigobar,...");
	}
	
	public String getTipo(){
		return "Standap";
	}
}
