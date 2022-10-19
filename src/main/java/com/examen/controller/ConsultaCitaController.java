package com.examen.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examen.constants.Status;
import com.examen.request.JsonResponse;
import com.examen.response.ApiResponse;
import com.examen.response.ApiResponseJson;
import com.examen.service.ConsultaService;

@Controller
public class ConsultaCitaController {

	@Autowired
	ConsultaService consultaservice;
	@RequestMapping("/consulta")
	@ResponseBody
	public Object consulta(@RequestParam("consultorio") int consultorio,
			@RequestParam("doctor") String doctor,
			@RequestParam("hora")Date hora,
			@RequestParam("nombrepaciente") String nombrepaciente ){
		
		Object jsonresp = consultaservice.consultadr(doctor);
		
		return new ApiResponse("200", jsonresp);
		
	}
	
	@RequestMapping("/actualizaconsulta")
	@ResponseBody
	public String actualizaconsulta(@RequestParam("consultorio") int consultorio,
			@RequestParam("doctor") String doctor,
			@RequestParam("hora")Date hora,
			@RequestParam("nombrepaciente") String nombrepaciente){
		
		consultaservice.actualizarconsulta(doctor, hora, consultorio);
		
		return "OK";
		
	}
	
	@RequestMapping("/eliminaconsulta")
	@ResponseBody
	public String eliminar(@RequestParam("consultorio") int consultorio,
			@RequestParam("doctor") String doctor,
			@RequestParam("hora")Date hora,
			@RequestParam("nombrepaciente") String nombrepaciente){
		
		consultaservice.eliminarconsulta(doctor, hora, consultorio);
		
		return "OK";
		
	}
}
