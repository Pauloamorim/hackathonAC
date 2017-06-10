package com.hackatonAC.grupo9.hackatonAC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackatonAC.grupo9.hackatonAC.model.Ponto;
import com.hackatonAC.grupo9.hackatonAC.repository.PontoRepository;

@Service
public class PontoService {

	@Autowired
	private PontoRepository pontoRepository;
	
	
	public Ponto registrarPonto(Ponto ponto){
		Ponto pontoRegistrado = pontoRepository.save(ponto);
		return pontoRegistrado;
	}
	
	
}
