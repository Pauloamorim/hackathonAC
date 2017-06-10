package com.hackatonAC.grupo9.hackatonAC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackatonAC.grupo9.hackatonAC.model.Localidade;
import com.hackatonAC.grupo9.hackatonAC.repository.LocalidadeRepository;

@Service
public class LocalidadeService {
	
	@Autowired
	private LocalidadeRepository localidadeRepository;
	
	
	public Localidade recuperarLocalidadePorNome(String nome){
		return localidadeRepository.findByNome(nome);
	}

}
