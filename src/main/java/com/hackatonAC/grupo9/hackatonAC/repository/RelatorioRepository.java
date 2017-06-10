package com.hackatonAC.grupo9.hackatonAC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hackatonAC.grupo9.hackatonAC.model.Ponto;
import com.hackatonAC.grupo9.hackatonAC.model.Regra;
import com.hackatonAC.grupo9.hackatonAC.pojo.estatico.DiaSemana;

public interface RelatorioRepository extends JpaRepository<Ponto, Long> {

	@Query(value="SELECT * FROM ponto where MONTH(data) = :mes and usuario_idusuario = :usuario  order by data",nativeQuery=true)
	public List<Ponto> listarDadosRelatorio(@Param("usuario") Long codUsuario,@Param("mes") Long codMes);

	@Query(value="SELECT r FROM PerfilRegra pr inner join pr.regra r where pr.perfil.id = :codPerfil and  r.diaSemana = :codDia and r.localidade.id = :idLocalidade ")
	public List<Regra> listarRegras(@Param("codPerfil") Long codPerfil,@Param("codDia") DiaSemana codDia,@Param("idLocalidade") Long idLocalidade);



}
