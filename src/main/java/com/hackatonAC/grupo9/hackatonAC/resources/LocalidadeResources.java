package com.hackatonAC.grupo9.hackatonAC.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackatonAC.grupo9.hackatonAC.model.Localidade;
import com.hackatonAC.grupo9.hackatonAC.service.LocalidadeService;

@RestController
@RequestMapping("/localidade")
public class LocalidadeResources {

	@Autowired
	private LocalidadeService localidadeService;


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Localidade>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(localidadeService.listar());

	}

}
