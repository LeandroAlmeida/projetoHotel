package recep��o;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestQuarto {

private Fachada fachada;
	
	@Before
	public void iniciar(){
		fachada= new Fachada();
	}

	@Test
	public void TestcadastroQuarto() {
		Quarto quarto1= criarQuartoModelo();
		fachada.cadastraQuarto(quarto1);
		Assert.assertEquals(quarto1, fachada.consultarInformacaoQuarto(05));
	}
	@Test(expected=Excecao.class)
	public void TestcadastroQuartoJaExistente() {
		Quarto quarto1= criarQuartoModelo();
		fachada.cadastraQuarto(quarto1);
		Assert.assertEquals(quarto1, fachada.consultarInformacaoQuarto(05));
		fachada.cadastraQuarto(quarto1);//exce��o, quarto j� cadastrado
	}
	
	@Test(expected=Excecao.class)
	public void TestRemoverQuarto() {
		Quarto quarto1= criarQuartoModelo();
		fachada.cadastraQuarto(quarto1);//adiciono quarto
		Assert.assertEquals(fachada.consultarInformacaoQuarto(05),quarto1);
		Assert.assertEquals(quarto1, fachada.removerQuarto(05));//remove o quarto, conferindo se o quarto que removeu e o mesmo que adicionou
		fachada.consultarInformacaoQuarto(05);//entra na exece��o, esse quarto n�o existe mais no sistema
	}
	
	@Test
	public void TestAlterarDescricaoQuarto() {
		Quarto quarto1= criarQuartoModelo();
		fachada.cadastraQuarto(quarto1);
		Assert.assertEquals(fachada.consultarInformacaoQuarto(05).getDescricao(),"Televis�o, frigobar, ventilador, sem terra�o!!!");//descri��o atual
		fachada.alterarDescricaoQuarto("Televis�o, frigobar, ARCONDICIONADO, sem terra�o!!!", "B�sico");//Alterando descri��o
		Assert.assertEquals(fachada.consultarInformacaoQuarto(05).getDescricao(),"Televis�o, frigobar, ARCONDICIONADO, sem terra�o!!!");//conferi se alterou
	}
	
	@Test
	public void TestAlterarPrecoQuarto() {
		Quarto quarto1= criarQuartoModelo();
		fachada.cadastraQuarto(quarto1);
		Assert.assertEquals(fachada.consultarInformacaoQuarto(05).getValor(),100.00);
		fachada.alterarPrecoQuarto(110.00,"B�sico");
		Assert.assertEquals(fachada.consultarInformacaoQuarto(05).getValor(),110.00);
		
	}
	
	@Test
	public void TestListaDeQuarto(){
		Quarto quarto1= criarQuartoModelo();
		fachada.cadastraQuarto(quarto1);
		Assert.assertEquals(fachada.listaDeQuartoAtual().size(), 1);
		Assert.assertEquals(fachada.listaDeQuartoAtual().get(0),quarto1);
	}
	
	private Quarto criarQuartoModelo() {
		Quarto q=new Quarto();
		q.setNumero(05);
		q.setTipoDeQuarto("B�sico");
		q.setDescricao("Televis�o, frigobar, ventilador, sem terra�o!!!");
		q.setValor(100.00);
		return q;
	}

}
