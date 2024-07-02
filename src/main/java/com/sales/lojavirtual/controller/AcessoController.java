package com.sales.lojavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.sales.lojavirtual.model.Acesso;
import com.sales.lojavirtual.service.AcessoService;

@Controller
@RestController
//@RequestMapping(value = "/acessos")
public class AcessoController {

	@Autowired
	private AcessoService acessoService;
	
	@ResponseBody /* Poder dar um retorno da API*/
	@PostMapping("/salvar")/*Mapeamento da url para receber Json*/
	public ResponseEntity<Acesso> salvar(@RequestBody Acesso acesso) { /* Recebe o Json  e converte em um objeto*/
		
		Acesso acessoSalvo = acessoService.salvar(acesso);
		
		return new ResponseEntity<Acesso>(acessoSalvo,HttpStatus.OK);

	}
	
	
}
