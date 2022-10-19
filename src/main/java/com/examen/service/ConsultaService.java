package com.examen.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.repository.AltaCitaRepository;
import com.examen.repository.ConsultaRepository;
import com.examen.request.JsonResponse;

@Service
public class ConsultaService {

	@Autowired
	ConsultaRepository altacitarepository;
	public Object consultadr(String doctor) {
	Object obj = altacitarepository.consultadr(doctor);
		return obj;
	}
	public void eliminarconsulta(String doctor,Date fecha, int piso) {
		altacitarepository.cancelacita(doctor,fecha,piso);
	}
	public void actualizarconsulta(String doctor,Date fecha, int piso) {
		altacitarepository.cancelacita(doctor,fecha, piso);
	}
}
