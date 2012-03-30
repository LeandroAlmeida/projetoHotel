package recepção;

import java.util.LinkedList;

public class GerenteFuncionario {
	private LinkedList<Funcionario> listaFuncionario;
	
	public GerenteFuncionario(){
		listaFuncionario=new LinkedList<Funcionario>();			
	}
	
	public void addFuncionario(Funcionario f){
		listaFuncionario.add(f);
	}
	
	public Funcionario consultaFuncionario(String cpf){
		for(Funcionario f: this.listaFuncionario){
			if(f.getCpf().equals(cpf))
				return f;
			}
		return null;//depois exception
		
	}
}
