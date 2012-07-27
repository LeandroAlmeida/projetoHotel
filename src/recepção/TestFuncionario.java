package recep��o;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFuncionario {
	
	private Fachada fachada;
	File f;
	@Before
	public void iniciar() throws IOException{
		/*if(new File("dados.bin").exists()){
			GerentePersistencia.apagarConteudoArquivo();
		}*/
		fachada= new Fachada();
	}
	
	@Test
	public void TestcadastroFuncionario() {
		Funcionario funcionario1= criarFuncionarioModelo();
		fachada.cadastroFuncionario(funcionario1);
		Assert.assertEquals(funcionario1, fachada.consultarFuncionario("22"));
		
	}
	
	@Test(expected=Excecao.class)
	public void TestFuncionarioInexistente(){
		fachada.consultarFuncionario("01");
	}
	
	@Test(expected=Excecao.class)
	public void TestRemoverFuncionarios(){
		Funcionario funcionario1= criarFuncionarioModelo();
		fachada.cadastroFuncionario(funcionario1);
		Assert.assertEquals(funcionario1, fachada.consultarFuncionario("22"));
		Assert.assertEquals(fachada.removerFuncionario("22"),funcionario1);//removeu funcion�rio
		fachada.consultarFuncionario("22");//funcion�rio n�o existe, entrar� na exce��o
	}
	
	@Test
	public void TestaAlterarDadosFuncionario(){
		Funcionario funcionario1= criarFuncionarioModelo();
		fachada.cadastroFuncionario(funcionario1);//esse funcion�rio foi cadastrado com cpf 22 com tel 3333-3333
		funcionario1=fachada.consultarFuncionario("22");
		funcionario1.setTel("4444-4444");
		fachada.alterarDadosFuncionario(funcionario1);//Atualiza os dados do funcion�rio(novo telefone)
		Assert.assertEquals(fachada.consultarFuncionario("22"), funcionario1);
	}
	
	@Test
	public void TestListaAtualDeFuncionario(){
		Assert.assertEquals(fachada.informaListaFuncionario().size(), 0);
		Funcionario funcionario1= criarFuncionarioModelo();
		fachada.cadastroFuncionario(funcionario1);
		Assert.assertEquals(fachada.informaListaFuncionario().size(), 1);
		Assert.assertEquals(fachada.informaListaFuncionario().get(0), funcionario1);
	}
	public Funcionario criarFuncionarioModelo(){
		
		Funcionario fun= new Funcionario();
		fun.setNome("Any");
		fun.setCpf("22");
		fun.setProfissao("atendente");
		fun.setRg("321");
		fun.setDataNascimento("19/03/1987");
		fun.setTel("3333-3333");
		fun.setEmail("meuEmail@dce.ufpb.br");
		
		return fun;
	}
}
