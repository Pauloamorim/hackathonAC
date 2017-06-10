package com.hackatonAC.grupo9.hackatonAC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackatonAC.grupo9.hackatonAC.model.Perfil;
import com.hackatonAC.grupo9.hackatonAC.repository.PerfilRepository;

@Service
public class PerfilService  {
	
	@Autowired
	public PerfilRepository perfilRepository;

	
	public List<Perfil>listarPerfis(){
		return perfilRepository.findAll();
	}

}
