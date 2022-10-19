package com.examen.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AltaCitaRepository extends CrudRepository<AltaCitaRepository, Integer> {

	@Query(value = "SELECT CASE WHEN EXISTS (select horadeconsulta from altacita where horadeconsulta= :horadeconsulta and consultorio= :consultorio) THEN FALSE ELSE TRUE END", nativeQuery = true)
	public boolean finByhoradeconsultaToconsultorio(@Param("horadeconsulta") Date horadeconsulta,
										  @Param("consultorio") int consultorio);
	
	@Query(value = "SELECT CASE WHEN EXISTS (select horadeconsulta from altacita where horadeconsulta= :horadeconsulta and doctor= :doctor) THEN FALSE ELSE TRUE END", nativeQuery = true)
	public boolean findhoradeconsultatodoctor(@Param("horadeconsulta") Date horadeconsulta,
										  @Param("doctor") String doctor);
	@Query(value = "select count(doctor) from altacita where doctor= :doctor", nativeQuery = true)
	public int numerodecitasdoc(@Param("doctor") String doctor);
	
	@Query(value = "INSERT INTO public.altacita (consultorio,doctor,horadeconsulta,nombredelpaciente) values(:consultorio,:doctor,:horadeconsulta,:nombredelpaciente)", nativeQuery = true)
	public boolean registrocita(@Param("consultorio") int consultorio,
							@Param("doctor") String doctor,
							@Param("horadeconsulta")Date horadeconsulta,
							@Param("nombredelpaciente")String nombredelpaciente);
	
}