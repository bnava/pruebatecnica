package com.examen.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.repository.AltaCitaRepository;

@Service
public class AltaDeCitasService {
	@Autowired
	AltaCitaRepository altacitarepository;
	
	public boolean altacita(int consultorio ,String doctor, Date hora, String nombredepaciente) {
		boolean response= false;
		boolean consultaunica = altacitarepository.finByhoradeconsultaToconsultorio(hora, consultorio);
		boolean  unicodr= altacitarepository.findhoradeconsultatodoctor(hora, doctor);
		int  numerodecitas = altacitarepository.numerodecitasdoc(doctor);
		boolean numcitas=numerodecitas>8?false:true;
		if (consultaunica && unicodr && numcitas) {
			altacitarepository.registrocita(consultorio, doctor, hora, nombredepaciente);
		response = true;
		}
		return response;
	}
}
