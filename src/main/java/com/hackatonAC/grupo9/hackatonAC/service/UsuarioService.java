package com.hackatonAC.grupo9.hackatonAC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackatonAC.grupo9.hackatonAC.model.Usuario;
import com.hackatonAC.grupo9.hackatonAC.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario obterUsuarioLogin(String login,String senha){

		return usuarioRepository.findByloginAndSenha(login, senha);
	}

}
