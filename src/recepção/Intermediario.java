package recepção;

public class Intermediario extends Quarto {
	public Intermediario(int numero){
		setValor(70.00);
		setNumero(numero);
		setDescricao("Quarto com Ar Condicionado, frigobar,...");
	}
	
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Intermediário";
	}
	
}
