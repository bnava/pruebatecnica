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
@Table(name = "public.consultorios")
public class Consultorios implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "numerodeconsutorio",unique=true, nullable = false)
	private Integer numerodeconsutorio;
	
	@Column(name = "piso", nullable = false)
	private Integer piso;
}
