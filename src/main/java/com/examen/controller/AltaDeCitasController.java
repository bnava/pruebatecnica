package com.examen.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examen.response.ApiResponse;
import com.examen.constants.Status;
import com.examen.service.AltaDeCitasService;

@Controller
public class AltaDeCitasController {
	
	@Autowired
	AltaDeCitasService altacitasservice;
	
	@RequestMapping("/altacita")
	@ResponseBody
	public String altacita(@RequestParam("consultorio") int consultorio,
			@RequestParam("doctor") String doctor,
			@RequestParam("hora")Date hora,
			@RequestParam("nombrepaciente") String nombrepaciente) {
		if (!altacitasservice.altacita(consultorio,doctor,hora,nombrepaciente )) {
		return new ApiResponse("200", Status.OK);//lombok no reconoce este parametro pero si realiza la funcion especificada.
	} else {
		return new ApiResponse("201", Status.ERROR);
	}
		return "";
	}
}
