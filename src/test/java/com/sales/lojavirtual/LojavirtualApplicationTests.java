package com.sales.lojavirtual;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.sales.lojavirtual.controller.AcessoController;
import com.sales.lojavirtual.model.Acesso;
import com.sales.lojavirtual.repository.AcessoRepository;

import junit.framework.TestCase;

@SpringBootTest(classes = LojavirtualApplication.class)
public class LojavirtualApplicationTests extends TestCase {

	@Autowired
	private AcessoController controller;
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	@Autowired
	private WebApplicationContext wac;

/*	@Test
	public void testCadastroAcesso() {

		Acesso acesso = new Acesso();
		
		//assertEquals(true, acesso.getId()== null);

		acesso.setDescricao("Role_DBAMaster");
	
		acesso = controller.salvar(acesso).getBody();
		
		assertEquals(true, acesso.getId() >0);
		

	}*/
	
	//Teste do end point salvar
	
	/*@Test
	public void testRestApiCadastroAcesso() throws  JsonProcessingException, Exception {
		
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("Role_Vendedor");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi= mockMvc.perform(MockMvcRequestBuilders.post("/salvar")
				.content(objectMapper.writeValueAsString(acesso))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON));
		
		System.out.println("retorno da Api :" + retornoApi.andReturn().getResponse().getContentAsString());
		
		Acesso objtoRetorno = objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(),Acesso.class);
		assertEquals(acesso.getDescricao(), objtoRetorno.getDescricao());
		
		
		

		
	}*/
	
	/*@Test
	public void testRestApiDeleteAcesso() throws  JsonProcessingException, Exception {
		
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("Role_Vendedor");
		acesso = repository.save(acesso);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi= mockMvc.perform(MockMvcRequestBuilders.post("/deletarAcesso")
				.content(objectMapper.writeValueAsString(acesso))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON));
		
		System.out.println("retorno da Api :" + retornoApi.andReturn().getResponse().getContentAsString());
		System.out.println("status do retorno :" + retornoApi.andReturn().getResponse().getStatus());
		
		assertEquals("Acesso Removido", retornoApi.andReturn().getResponse().getContentAsString());
		assertEquals(200,retornoApi.andReturn().getResponse().getStatus());
		
	}*/
	
/*	@Test
	public void testRestApiDeletePorIdAcesso() throws  JsonProcessingException, Exception {
		
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("Role_TESTE_DELETE_ID");
		acesso = repository.save(acesso);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi= mockMvc.perform(MockMvcRequestBuilders.post("/deletarAcesso")
				.content(objectMapper.writeValueAsString(acesso))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON));
		
		System.out.println("retorno da Api :" + retornoApi.andReturn().getResponse().getContentAsString());
		System.out.println("status do retorno :" + retornoApi.andReturn().getResponse().getStatus());
		
		assertEquals("Acesso Removido", retornoApi.andReturn().getResponse().getContentAsString());
		assertEquals(200,retornoApi.andReturn().getResponse().getStatus());
		
	}*/
	
/*	@Test
	public void testRestApiObterAcessoId() throws  JsonProcessingException, Exception {
		
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("Role_OBTER_ID");
		acesso = repository.save(acesso);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi= mockMvc.perform(MockMvcRequestBuilders.get("/obterAcesso/" + acesso.getId())
				.content(objectMapper.writeValueAsString(acesso))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON));
		
		assertEquals(200,retornoApi.andReturn().getResponse().getStatus());
		
		Acesso acessoRetorno =  objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(),Acesso.class);
		
	
		assertEquals(acesso.getDescricao(), acessoRetorno.getDescricao());
		assertEquals(acesso.getId(), acessoRetorno.getId());
		
		
	}*/
	
	@Test
	public void testRestApiObterAcessoDesc() throws  JsonProcessingException, Exception {
		
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("Role_OBTER_LIST");
		acesso = acessoRepository.save(acesso);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi= mockMvc.perform(MockMvcRequestBuilders.get("/buscarAcessoDesc/OBTER_LIST")
				.content(objectMapper.writeValueAsString(acesso))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON));
		
		assertEquals(200,retornoApi.andReturn().getResponse().getStatus());
		
		List<Acesso> listaRetorno =  objectMapper.
				readValue(retornoApi
						.andReturn()
						.getResponse()
						.getContentAsString(),
						new TypeReference<List<Acesso>>() {});
		
		assertEquals(1, listaRetorno.size());
		assertEquals(acesso.getDescricao(), listaRetorno.get(0).getDescricao());
	
	acessoRepository.deleteById(acesso.getId());
		
		
	}
	
	

}
