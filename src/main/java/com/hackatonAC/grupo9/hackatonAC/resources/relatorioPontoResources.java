package com.hackatonAC.grupo9.hackatonAC.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackatonAC.grupo9.hackatonAC.model.Ponto;
import com.hackatonAC.grupo9.hackatonAC.service.RelatorioService;

@RestController
@RequestMapping("/relatorioPonto")
public class relatorioPontoResources {

	@Autowired
	private RelatorioService relatorioService;

	@RequestMapping()
	public void listar(@RequestParam(name="usuario") Long idUsuario,@RequestParam(name="mes") Long codMes){
		final List<Ponto> listarDadosRelatorioPonto = relatorioService.listarDadosRelatorioPonto(idUsuario, codMes);
		final Map<String,List<Ponto>> mapaAgrupador = new HashMap<String,List<Ponto>>();

		relatorioService.montarDados(mapaAgrupador, listarDadosRelatorioPonto);





	}

}
