package recepção;

public class Quarto {
	
	
	private int numero;
	TipoQuarto tipo;
	
	public Quarto(){
		this.numero=0;
		this.tipo=new TipoQuarto();
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
