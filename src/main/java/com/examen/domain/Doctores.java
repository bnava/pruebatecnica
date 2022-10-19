package com.examen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "public.doctores")
public class Doctores{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "nombre",unique=true, nullable = false)
	private Integer nombre;
	
	@Column(name = "appellidopaterno", nullable = false)
	private Integer appellidopaterno;
	
	@Column(name = "appellidomaterno", nullable = false)
	private Integer appellidomaterno;
	
	@Column(name = "especialidad", nullable = false)
	private Integer especialidad;
	
}
