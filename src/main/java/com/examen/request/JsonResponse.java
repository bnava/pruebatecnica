package com.examen.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResponse {
	private Integer id;
	private String doctor;
	private Integer piso;
	private Date hora;
	private String nombredepaciente;
}
