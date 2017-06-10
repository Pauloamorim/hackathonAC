package com.hackatonAC.grupo9.hackatonAC.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackatonAC.grupo9.hackatonAC.model.Perfil;
import com.hackatonAC.grupo9.hackatonAC.service.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilResources {

	@Autowired
	private PerfilService perfilService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Perfil>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(perfilService.listarPerfis());
	}
	
}
