package recepção;

import java.util.LinkedList;
import java.util.List;

public class GerenteFuncionario {

	public LinkedList<Funcionario> listaFuncionarios;

	public GerenteFuncionario() {

		listaFuncionarios = new LinkedList<Funcionario>();

	}

	public void cadastroFuncionario(Funcionario f) {
		for(Funcionario fun:this.listaFuncionarios){
			if(fun.getCpf().equals(f.getCpf()))
				throw new Excecao("Cpf ja cadastrado!!!");
		}
		listaFuncionarios.add(f);

	}

	public Funcionario removerFuncionario(String cpf) {
		Funcionario funRemovido;
		for (Funcionario f : this.listaFuncionarios) {
			if (f.getCpf().equals(cpf)) {
				listaFuncionarios.remove(f);
				funRemovido = f;
				return funRemovido;
			}
		}
		throw new Excecao("Funcionario não existente");
	}

	public Funcionario consultarFuncionario(String cpf) {
		
		for (Funcionario f : this.listaFuncionarios) {
			if (f.getCpf().equals(cpf))
				return f;
		}
		throw new Excecao("Funcionario não existente");

	}

	public List<Funcionario> informaListaFuncionario() {
		return listaFuncionarios;

	}

	public Funcionario alterarDadosFuncionario(Funcionario fun){
			for (Funcionario f : this.listaFuncionarios) {
					if(fun.getCpf().equals(f.getCpf())){
						f=fun;
					return f;
					}
				}
			throw new Excecao("Funcionario não existente");
			}
				
	}
	
