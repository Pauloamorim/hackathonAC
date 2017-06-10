package com.hackatonAC.grupo9.hackatonAC.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackatonAC.grupo9.hackatonAC.model.Localidade;
import com.hackatonAC.grupo9.hackatonAC.model.Ponto;
import com.hackatonAC.grupo9.hackatonAC.model.Usuario;
import com.hackatonAC.grupo9.hackatonAC.service.LocalidadeService;
import com.hackatonAC.grupo9.hackatonAC.service.PontoService;
import com.hackatonAC.grupo9.hackatonAC.service.UsuarioService;

@RestController
@RequestMapping("/ponto")
public class PontoResources {
	
	@Autowired
	private PontoService pontoService;
	
	@Autowired
	private LocalidadeService localidadeService;
	
	
	@RequestMapping(value="/registrar", method = RequestMethod.POST)
	public ResponseEntity<?> registrar( @RequestBody Ponto ponto) {
		Localidade localidade = localidadeService.recuperarLocalidadePorNome(ponto.getLocalidade().getNome());
		ponto.setLocalidade(localidade);
		
		pontoService.registrarPonto(ponto);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
