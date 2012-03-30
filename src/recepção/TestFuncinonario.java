package recepção;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestFuncinonario {
	private Fachada f;
	@Before
	public void inicia(){
		f=new Fachada();
	}

	@Test
	public void testCadastroFuncionario() {
		Funcionario funcionario = criarFuncionarioExemplo1();
		f.cadastroFuncionario(funcionario);
		Assert.assertEquals(funcionario, f.consultarFuncionario("000.000.000"));
		//Assert.assertEquals(funcionario, f.consultarFuncionario("100.000.000"));
	}

	@Test
	public void testCadastroFuncionarioInexistente() {
		Funcionario funcionario = criarFuncionarioExemplo1();
		f.cadastroFuncionario(funcionario);
		Assert.assertNull(f.consultarFuncionario("100.000.000"));
	}

	private Funcionario criarFuncionarioExemplo1() {
		Funcionario funcionario=new Funcionario();
		funcionario.setNome("Any");
		funcionario.setDataNacimento(null);
		funcionario.setCpf("000.000.000");
		funcionario.setRg("323232");
		funcionario.setProfissao("professor");
		return funcionario;
	}

}
