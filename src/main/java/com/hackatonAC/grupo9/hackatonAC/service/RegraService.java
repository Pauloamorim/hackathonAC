package com.hackatonAC.grupo9.hackatonAC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackatonAC.grupo9.hackatonAC.model.Regra;
import com.hackatonAC.grupo9.hackatonAC.repository.RegraRepository;

@Service
public class RegraService {

	@Autowired
	private RegraRepository regraRepository;

	public void salvar(Regra regra){
		regraRepository.save(regra);
	}

}
