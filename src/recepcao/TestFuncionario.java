package recepcao;

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
	@Before
	public void iniciar() throws IOException{
		GerentePersistencia.reset();
		fachada= new Fachada();
		
	}
	
	@After
	public void fim() throws IOException{
		GerentePersistencia.apagarConteudoArquivo();

	}
	
	@Test
	public void testcadastroFuncionario() {
		Funcionario funcionario1= criarFuncionarioModelo();
		fachada.cadastroFuncionario(funcionario1);
		Assert.assertEquals(funcionario1, fachada.consultarFuncionario("22"));
		
	}
	
	@Test(expected=Excecao.class)
	public void testFuncionarioInexistente(){
		fachada.consultarFuncionario("01");
	}
	
	@Test(expected=Excecao.class)
	public void testRemoverFuncionarios(){
		Funcionario funcionario1= criarFuncionarioModelo();
		fachada.cadastroFuncionario(funcionario1);
		Assert.assertEquals(funcionario1, fachada.consultarFuncionario("22"));
		Assert.assertEquals(fachada.removerFuncionario("22"),funcionario1);//removeu funcionário
		fachada.consultarFuncionario("22");//funcionário não existe, entrará na exceção
	}
	
	@Test
	public void testaAlterarDadosFuncionario(){
		Funcionario funcionario1= criarFuncionarioModelo();
		fachada.cadastroFuncionario(funcionario1);//esse funcionário foi cadastrado com cpf 22 com tel 3333-3333
		funcionario1=fachada.consultarFuncionario("22");//procura o funcionario(pelo cpf)
		funcionario1.setTel("4444-4444");
		fachada.alterarDadosFuncionario(funcionario1);//Atualiza os dados do funcionário(novo telefone)
		Assert.assertEquals(fachada.consultarFuncionario("22").getTel(), "4444-4444");
	}
	
	@Test
	public void testListaAtualDeFuncionario(){
		Assert.assertEquals(fachada.informaListaFuncionario().size(), 0);
		Funcionario funcionario1= criarFuncionarioModelo();
		fachada.cadastroFuncionario(funcionario1);
		Assert.assertEquals(fachada.informaListaFuncionario().size(), 1);
		Assert.assertEquals(fachada.informaListaFuncionario().get(0), funcionario1);
	}
	
	@Test
	public void testPersistencia(){
		Funcionario funcionario1= criarFuncionarioModelo();
		fachada.cadastroFuncionario(funcionario1);
		fachada=new Fachada();
		Assert.assertEquals(funcionario1, fachada.consultarFuncionario("22"));
		funcionario1=fachada.consultarFuncionario("22");//procura o funcionario(pelo cpf)
		funcionario1.setTel("4444-4444");//altera os dados
		funcionario1.setEmail("meuEmailAlterado@dce.ufpb.br");
		fachada.alterarDadosFuncionario(funcionario1);// altera no banco de dados
		fachada=new Fachada();
		Assert.assertEquals(fachada.consultarFuncionario("22").getTel(),"4444-4444");
		Assert.assertEquals(fachada.consultarFuncionario("22").getEmail(),"meuEmailAlterado@dce.ufpb.br");
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
