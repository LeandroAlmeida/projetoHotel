package recepção;

public class Luxo extends Quarto{
	public Luxo(int numero){
		setValor(100.00);
		setNumero(numero);
		setDescricao("Quarto com Ar Condicionado, frigobar, varanda,...");
	}
	
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Luxo";
	}
	
}
