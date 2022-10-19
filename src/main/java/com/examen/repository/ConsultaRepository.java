package com.examen.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.examen.domain.AltaCitaDomain;

public interface ConsultaRepository extends CrudRepository<ConsultaRepository, Integer> {

	@Query(value = "select * from altacita where doctor = :doctor", nativeQuery = true)
	public List<AltaCitaDomain> consultadr(@Param("doctor") String doctor);
	
	@Query(value = "delete from altacita where doctor = :doctor and horadeconsulta = :fecha and piso = piso", nativeQuery = true)
	public void cancelacita(@Param("doctor") String doctor,@Param("fecha") Date fecha, @Param("piso") int piso);

	@Query(value = "UPDATE altacita SET consultorio = :consultorio, doctor = :doctor, horadeconsulta = :horadeconsulta, nombredepaciente = :nombredepacinte where doctor = :doctor, horadeconsulta = :horadeconsulta", nativeQuery = true)
	public void actualizacita(@Param("consultorio") int consultorio,
			@Param("doctor") String doctor,
			@Param("horadeconsulta") Date horadeconsulta,
			@Param("nombredepacinte") String nombredepacinte);
	
}
	
