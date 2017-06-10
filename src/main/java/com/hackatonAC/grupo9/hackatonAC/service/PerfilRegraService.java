package com.hackatonAC.grupo9.hackatonAC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackatonAC.grupo9.hackatonAC.model.PerfilRegra;
import com.hackatonAC.grupo9.hackatonAC.model.Regra;
import com.hackatonAC.grupo9.hackatonAC.repository.PerfilRegraRepository;

@Service
public class PerfilRegraService {

	@Autowired
	private PerfilRegraRepository perfilRegraRepository;


	public void salvar(PerfilRegra perfilRegra){

		for(final Regra r : perfilRegra.getListaRegras()){
			final PerfilRegra pr = new PerfilRegra();
			pr.setPerfil(perfilRegra.getPerfil());
			pr.setRegra(r);
			perfilRegraRepository.save(pr);
		}
	}

}
