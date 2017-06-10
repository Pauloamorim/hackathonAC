package com.hackatonAC.grupo9.hackatonAC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackatonAC.grupo9.hackatonAC.model.Localidade;

public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {

	Localidade findByNome(String nome);
	
}
