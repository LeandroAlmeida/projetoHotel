package recepcao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class GerenteFuncionario implements Serializable {


	
	//public LinkedList<Funcionario> listaFuncionarios; 


	public void cadastroFuncionario(Funcionario f) {
			for(Funcionario fun:GerentePersistencia.getInstance().getListaFuncionarios()){
				if(fun.getCpf().equals(f.getCpf()))
					throw new Excecao("Cpf ja cadastrado!!!");
			}
			GerentePersistencia.getInstance().getListaFuncionarios().add(f);
			GerentePersistencia.persistir();
		}


	public Funcionario removerFuncionario(String cpf) {
		Funcionario funRemovido;
		for (Funcionario f : GerentePersistencia.getInstance().getListaFuncionarios()) {
			if (f.getCpf().equals(cpf)) {
				GerentePersistencia.getInstance().getListaFuncionarios().remove(f);
				GerentePersistencia.persistir();
				funRemovido = f;
				return funRemovido;
			}
		}
		throw new Excecao("Funcionario não existente");
	}

	public Funcionario consultarFuncionario(String cpf) {
		
		for (Funcionario f : GerentePersistencia.getInstance().getListaFuncionarios()) {
			if (f.getCpf().equals(cpf))
				return f;
		}
		throw new Excecao("Funcionario não existente");

	}

	public List<Funcionario> informaListaFuncionario() {
		return GerentePersistencia.getInstance().getListaFuncionarios();

	}

	public Funcionario alterarDadosFuncionario(Funcionario fun){
			for (Funcionario f : GerentePersistencia.getInstance().getListaFuncionarios()) {
					if(fun.getCpf().equals(f.getCpf())){
						f=fun;
						GerentePersistencia.persistir();
						return f;
					}
				}
			throw new Excecao("Funcionario não existente");
			}
				
	}
	
