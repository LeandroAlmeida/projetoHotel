package recepção;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHospede {


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
	public void testcadastroHospede() {
		Hospede hospede1= criarHospedeModelo();
		fachada.cadastroHospede(hospede1);
		Assert.assertEquals(hospede1, fachada.consultarHospede("23"));	
	}
	
	@Test(expected=Excecao.class)
	public void testCadastroHospedeJaExistente(){
		Hospede hospede1= criarHospedeModelo();
		fachada.cadastroHospede(hospede1);
		fachada.cadastroHospede(hospede1);//Exceção, hospede já cadastrado!!
	}
	@Test
	public void testalterarDadosHospede(){
		Hospede hospede1= criarHospedeModelo();
		fachada.cadastroHospede(hospede1);//esse funcionário foi cadastrado com cpf 23 e com tel 1111-1111
		hospede1=fachada.consultarHospede("23");
		hospede1.setTel("0000-0000");
		hospede1.setEmail("nome@hotmail.com");
		fachada.alterarDadosHospede(hospede1);//Atualiza os dados do hospede(novo telefone)
		Assert.assertEquals(fachada.consultarHospede("23").getTel(), hospede1.getTel());
		Assert.assertEquals(fachada.consultarHospede("23").getEmail(), hospede1.getEmail());
	}

	@Test(expected=Excecao.class)
	public void testRemoverHospede(){
		Hospede hospede1= criarHospedeModelo();
		fachada.cadastroHospede(hospede1);//cadastro funcionário(cpf 23)
		Assert.assertEquals(fachada.removerHospede("23"),hospede1);//Remove funcionário(cpf 23)
		fachada.consultarHospede("23");//confere se foi removido, ele não existe(entra na exceção)
	}
	
	@Test(expected=Excecao.class)
	public void testRemoverHospedeInexistente(){
		fachada.removerHospede("23");//Exceção hospede inexistente!
	}
	
	@Test(expected=Excecao.class)
	public void testConsultarHospedeInexistente(){
		Hospede hospede1=fachada.consultarHospede("01");
	}
	
	@Test
	public void testPersistencia(){
		Hospede hospede1= criarHospedeModelo();
		fachada.cadastroHospede(hospede1);
		fachada=new Fachada();
		Assert.assertEquals(hospede1, fachada.consultarHospede("23"));
		hospede1=fachada.consultarHospede("23");
		hospede1.setTel("4444-4444");
		hospede1.setEmail("meuEmailAlterado@dce.ufpb.br");
		fachada.alterarDadosHospede(hospede1);
		fachada=new Fachada();
		Assert.assertEquals(fachada.consultarHospede("23").getTel(),"4444-4444");
		Assert.assertEquals(fachada.consultarHospede("23").getEmail(),"meuEmailAlterado@dce.ufpb.br");
		
	}
	
	private Hospede criarHospedeModelo() {
		// TODO Auto-generated method stub
		Hospede h=new Hospede();
		h.setCpf("23");
		h.setDataNacimento("10/04/2012");
		h.setEmail("meuEmail@dce,ufpb.br");
		h.setNome("Lucinete");
		h.setRg("678");
		h.setTel("1111-1111");
		return h;
	}

}
