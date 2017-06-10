package com.hackatonAC.grupo9.hackatonAC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackatonAC.grupo9.hackatonAC.model.Perfil;

public interface PerfilRepository  extends JpaRepository<Perfil, Long>{

	
	List<Perfil> findAll();
	
}
