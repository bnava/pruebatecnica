package com.examen.response;

import com.examen.request.JsonResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponseJson {

	private String status;
    private JsonResponse data;
	
}
