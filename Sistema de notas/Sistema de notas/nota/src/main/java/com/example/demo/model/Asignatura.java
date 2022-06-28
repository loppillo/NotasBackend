package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información o propiedades de asignatura")

@Entity
@Table(name="Asignatura")
public class Asignatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id_asignatura;
	
	@Size(min=8,max=20,message="El nombre de la asignatura deben ser igual o mayor de 8 y menor o igual a 20")
	@Column(name="NombreAsignatura", length = 20)
	private String NombreAsignatura;
	
	@Min(value = 1, message = "El minimo de nota debe ser igual o mayor a 1")
    @Max(value = 7, message = "El maximo de nota  debe ser igual o menor de 7")
	@Column(name="Nota", length = 20)
	private Float Nota;
	
	@Size(min=8,max=20,message="El nombre del semestre debe ser igual o mayor de 8 y menor o igual a 20")
	@Column(name="Semestre", length = 20 )
	private String Semestre;
	
	
	private Float PromedioSemestre;


	public Integer getId_asignatura() {
		return id_asignatura;
	}


	public void setId_asignatura(Integer id_asignatura) {
		this.id_asignatura = id_asignatura;
	}


	public String getNombreAsignatura() {
		return NombreAsignatura;
	}


	public void setNombreAsignatura(String nombreAsignatura) {
		NombreAsignatura = nombreAsignatura;
	}


	public Float getNota() {
		return Nota;
	}


	public void setNota(Float nota) {
		Nota = nota;
	}


	public String getSemestre() {
		return Semestre;
	}


	public void setSemestre(String semestre) {
		Semestre = semestre;
	}


	public Float getPromedioSemestre() {
		return PromedioSemestre;
	}


	public void setPromedioSemestre(Float promedioSemestre) {
		PromedioSemestre = promedioSemestre;
	}

	
	
	
}
