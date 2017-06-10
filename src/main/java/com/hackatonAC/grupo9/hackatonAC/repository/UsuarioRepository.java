package com.hackatonAC.grupo9.hackatonAC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackatonAC.grupo9.hackatonAC.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


	Usuario findByloginAndSenha(String login, String senha);

}
