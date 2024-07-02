package com.sales.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.lojavirtual.model.Acesso;
import com.sales.lojavirtual.repository.AcessoRepository;

@Service
public class AcessoService {
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	public Acesso salvar(Acesso acesso) {
		
		return acessoRepository.save(acesso);
	}

}
