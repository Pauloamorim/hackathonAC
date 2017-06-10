package com.hackatonAC.grupo9.hackatonAC.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackatonAC.grupo9.hackatonAC.dto.RelatorioPontoDTO;
import com.hackatonAC.grupo9.hackatonAC.model.Ponto;
import com.hackatonAC.grupo9.hackatonAC.model.Regra;
import com.hackatonAC.grupo9.hackatonAC.pojo.estatico.DiaSemana;
import com.hackatonAC.grupo9.hackatonAC.repository.RelatorioRepository;

@Service
public class RelatorioService {

	@Autowired
	private RelatorioRepository relatorioRepository;

	public List<Ponto> listarDadosRelatorioPonto(Long idUsuario,Long codMes){

		return relatorioRepository.listarDadosRelatorio(idUsuario,codMes);
	}

	public List<RelatorioPontoDTO> montarDados(final Map<String,List<Ponto>> mapaAgrupador,List<Ponto> listarDadosRelatorioPonto){
		for (final Ponto ponto : listarDadosRelatorioPonto) {
			if(mapaAgrupador.get(ponto.getDataFormatada()) == null){
				final List<Ponto> lista = new ArrayList<Ponto>();
				lista.add(ponto);
				mapaAgrupador.put(ponto.getDataFormatada(), lista);
			}else{
				final List<Ponto> lista = mapaAgrupador.get(ponto.getDataFormatada());
				lista.add(ponto);
			}
		}

		final List<RelatorioPontoDTO> lista = new ArrayList<RelatorioPontoDTO>();

		for(final Entry<String,List<Ponto>> entry : mapaAgrupador.entrySet()){
			final RelatorioPontoDTO dto = new RelatorioPontoDTO();
			dto.setDia(entry.getKey());
			final List<Ponto> listaPonto = entry.getValue();
			dto.setPonto1(listaPonto.get(0).getHora());
			dto.setPonto2(listaPonto.get(1).getHora());
			dto.setPonto3(listaPonto.get(2).getHora());
			dto.setPonto4(listaPonto.get(3).getHora());


			final long dif = listaPonto.get(1).getData().getTime() - listaPonto.get(0).getData().getTime();
			final long horasTrabalhadasManha = TimeUnit.HOURS.convert(dif, TimeUnit.MILLISECONDS);

			final long difTarde = listaPonto.get(3).getData().getTime() - listaPonto.get(2).getData().getTime();
			final long horasTrabalhadasTarde = TimeUnit.HOURS.convert(dif, TimeUnit.MILLISECONDS);


			final List<Regra> listarRegras = listarRegras(listaPonto);

		}
		return null;
	}


	private Long retornaHora(Date data){
		return data.getTime() / 24 / 60;
	}

	private List<Regra> listarRegras(final List<Ponto> listaPonto) {
		final Ponto ponto = listaPonto.get(0);
		final Long idLocalidade = ponto.getLocalidade().getId();
		final Calendar c = Calendar.getInstance();
		c.setTime(ponto.getData());
		final DiaSemana diaSemana = DiaSemana.obterDiaSemanaPorOrdinal(c.get(Calendar.DAY_OF_WEEK) - 1);
		final Long codPerfil = ponto.getUsuario().getPerfil().getId();


		return relatorioRepository.listarRegras(codPerfil,diaSemana,idLocalidade);
	}


}
