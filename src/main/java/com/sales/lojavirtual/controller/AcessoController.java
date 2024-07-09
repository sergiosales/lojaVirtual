package com.sales.lojavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.sales.lojavirtual.model.Acesso;
import com.sales.lojavirtual.repository.AcessoRepository;
import com.sales.lojavirtual.service.AcessoService;

@Controller
@RestController
//@RequestMapping(value = "/acessos")
public class AcessoController {

	@Autowired
	private AcessoService acessoService;
	
	@Autowired
	private AcessoRepository repository;
	
	@ResponseBody /* Poder dar um retorno da API*/
	@PostMapping(value = "/salvar")/*Mapeamento da url para receber Json*/
	public ResponseEntity<Acesso> salvar(@RequestBody Acesso acesso) { /* Recebe o Json  e converte em um objeto*/
		
		Acesso acessoSalvo = acessoService.salvar(acesso);
		
		return new ResponseEntity<Acesso>(acessoSalvo,HttpStatus.OK);

	}
	
	
	@ResponseBody
	@DeleteMapping("/deletarAcesso")
	public ResponseEntity<?> deleteAcesso(@RequestBody Acesso acesso){/*Recebe um Json  e converte para o objeto*/
    repository.deleteById(acesso.getId());
    
   return new ResponseEntity("Acesso Removido",HttpStatus.OK);
		
	}
	

	@ResponseBody
	@DeleteMapping("/deletarAcessoPorId/{id}")
	public ResponseEntity<?> deletarAcessoPorId(@PathVariable("id")Long id){/*Recebe um Json  e converte para o objeto*/
    repository.deleteById(id);
    
   return new ResponseEntity("Acesso Removido",HttpStatus.OK);
		
	}
	
	@ResponseBody
	@GetMapping("/buscarAcessoDesc/{desc}")
	public ResponseEntity<List<Acesso>> buscarPorDesc(@PathVariable("desc")String desc){/*Recebe um Json  e converte para o objeto*/
   
		List<Acesso> acesso = repository.buscarAcessoDesc(desc);
    
   return new ResponseEntity<List<Acesso>>(acesso,HttpStatus.OK);
		
	}
	
	
	
	
	
}
