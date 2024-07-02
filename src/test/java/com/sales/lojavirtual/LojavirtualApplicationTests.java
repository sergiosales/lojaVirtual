package com.sales.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.sales.lojavirtual.controller.AcessoController;
import com.sales.lojavirtual.model.Acesso;

import junit.framework.TestCase;

@SpringBootTest(classes = LojavirtualApplication.class)
public class LojavirtualApplicationTests extends TestCase {

	@Autowired
	private AcessoController controller;

	@Test
	public void testCadastroAcesso() {

		Acesso acesso = new Acesso();
		
		//assertEquals(true, acesso.getId()== null);

		acesso.setDescricao("Role_DBAMaster");
	
		acesso = controller.salvar(acesso).getBody();
		
		assertEquals(true, acesso.getId()< 0);
		

	}

}
