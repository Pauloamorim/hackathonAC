package com.hackatonAC.grupo9.hackatonAC.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackatonAC.grupo9.hackatonAC.model.PerfilRegra;
import com.hackatonAC.grupo9.hackatonAC.service.PerfilRegraService;

@RestController
@RequestMapping("/vinculo")
public class PerfilRegraResources {

	@Autowired
	private PerfilRegraService perfilRegraService;


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody PerfilRegra perfilRegra) {
		try {
			perfilRegraService.salvar(perfilRegra);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (final Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

}
