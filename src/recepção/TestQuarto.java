package recepção;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestQuarto {

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
		fachada.cadastraQuarto(quarto1);//exceção, quarto já cadastrado
	}
	
	@Test(expected=Excecao.class)
	public void testRemoverQuarto() {
		Quarto quarto1= criarQuartoModelo();
		fachada.cadastraQuarto(quarto1);//adiciona quarto
		Assert.assertEquals(fachada.consultarInformacaoQuarto(05),quarto1);
		Assert.assertEquals(quarto1, fachada.removerQuarto(05));//remove o quarto, conferindo se o quarto removido é o mesmo que foi adicionado
		fachada.consultarInformacaoQuarto(05);//entra na execeção, esse quarto não existe mais no sistema.
	}
	
	@Test(expected=Excecao.class)
	public void testRemoverQuartoInexistente(){
		fachada.removerQuarto(05);
	}
	
	@Test
	public void TestAlterarDescricaoQuarto() {
		Quarto quarto1= criarQuartoModelo();
		fachada.cadastraQuarto(quarto1);
		Assert.assertEquals(fachada.consultarInformacaoQuarto(05).getDescricao(),"Televisão, frigobar, ventilador, sem terraço!!!");//descrição atual
		fachada.alterarDescricaoQuarto("Televisão, frigobar, ARCONDICIONADO, sem terraço!!!", "Básico");//Alterando a descrição do(s) quarto(s) de tipo Básico
		Assert.assertEquals(fachada.consultarInformacaoQuarto(05).getDescricao(),"Televisão, frigobar, ARCONDICIONADO, sem terraço!!!");//conferi se alterou
	}
	
	@Test
	public void TestAlterarPrecoQuarto() {
		Quarto quarto1= criarQuartoModelo();
		fachada.cadastraQuarto(quarto1);
		Assert.assertEquals(fachada.consultarInformacaoQuarto(05).getValor(),100.00);
		fachada.alterarPrecoQuarto(110.00,"Básico");
		Assert.assertEquals(fachada.consultarInformacaoQuarto(05).getValor(),110.00);
		
	}
	
	@Test
	public void TestListaDeQuarto(){
		Assert.assertEquals(fachada.listaDeQuartoAtual().size(), 0);
		Quarto quarto1= criarQuartoModelo();
		fachada.cadastraQuarto(quarto1);
		Assert.assertEquals(fachada.listaDeQuartoAtual().size(), 1);
		Assert.assertEquals(fachada.listaDeQuartoAtual().get(0),quarto1);
	}
	
	@Test
	public void TestPersistencia(){
		Quarto quarto1= criarQuartoModelo();//quarto modelo, Basico.
		fachada.cadastraQuarto(quarto1);
		fachada=new Fachada();
		Assert.assertEquals(quarto1, fachada.consultarInformacaoQuarto(05));//verifica se salvou
		quarto1=fachada.consultarInformacaoQuarto(05);
		fachada.alterarPrecoQuarto(110.00, "Básico");//alterando valor de 100 para 110 dos quartos Básicos
		Assert.assertEquals(110.00, fachada.consultarInformacaoQuarto(05).getValor());
		fachada=new Fachada();
		Assert.assertEquals(110.00, fachada.consultarInformacaoQuarto(05).getValor());//verifica se salvou
		
	}
	
	private Quarto criarQuartoModelo() {
		Quarto q=new Quarto();
		q.setNumero(05);
		q.setTipoDeQuarto("Básico");
		q.setDescricao("Televisão, frigobar, ventilador, sem terraço!!!");
		q.setValor(100.00);
		return q;
	}

}
