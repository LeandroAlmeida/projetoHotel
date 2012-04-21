package recepção;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestHospede {


	private Fachada fachada;
	
	@Before
	public void iniciar(){
		fachada= new Fachada();
	}

	@Test
	public void TestcadastroHospede() {
		Hospede hospede1= criarHospedeModelo();
		fachada.cadastroHospede(hospede1);
		Assert.assertEquals(hospede1, fachada.consultarHospede("23"));	
	}
	@Test
	public void TestalterarDadosHospede(){
		Hospede hospede1= criarHospedeModelo();
		fachada.cadastroHospede(hospede1);//esse funcionário foi cadastrado com cpf 23 e com tel 1111-1111
		hospede1=fachada.consultarHospede("23");
		hospede1.setTel("0000-0000");
		fachada.alterarDadosHospede(hospede1);//Atualiza os dados do funcionário(novo telefone)
		Assert.assertEquals(fachada.consultarHospede("23").getTel(), hospede1.getTel());
	}

	@Test(expected=Excecao.class)
	public void TestRemoverHospede(){
		Hospede hospede1= criarHospedeModelo();
		fachada.cadastroHospede(hospede1);//cadastro funcionário(cpf 23)
		Assert.assertEquals(fachada.removerHospede("23"),hospede1);//Remove funcionário(cpf 23)
		fachada.consultarHospede("23");//confere se foi removido, ele não existe(entra na exceção)
	}
	
	@Test(expected=Excecao.class)
	public void TestHospedeInexistente(){
		Hospede hospede1=fachada.consultarHospede("01");
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
