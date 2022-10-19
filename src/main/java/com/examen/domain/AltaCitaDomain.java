package com.examen.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "public.altacita")
public class AltaCitaDomain implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "consultorio",unique=true, nullable = false)
	private Integer consultorio;
	
	@Column(name = "doctor", nullable = false, length = 255)
	private String doctor;
	
	@Column(name = "horadeconsulta")
	private Date horadeconsulta;
	
	@Column(name = "nombredelpaciente", nullable = false, length = 255)
	private String nombredelpaciente;
}