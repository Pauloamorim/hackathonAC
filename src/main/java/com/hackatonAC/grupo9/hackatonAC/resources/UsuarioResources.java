package com.hackatonAC.grupo9.hackatonAC.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackatonAC.grupo9.hackatonAC.model.Usuario;
import com.hackatonAC.grupo9.hackatonAC.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResources {

	@Autowired
	private UsuarioService usuarioService;


	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<Void> logar( @RequestBody Usuario usuario) {

		final Usuario usuarioConsultado = usuarioService.obterUsuarioLogin(usuario.getLogin(), usuario.getSenha());
		if(usuario == null){

		}else{

		}

		return null;
	}

}
