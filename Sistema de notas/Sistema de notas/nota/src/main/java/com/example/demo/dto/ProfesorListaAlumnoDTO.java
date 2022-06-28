package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Alumno;
import com.example.demo.model.Profesor;


public class ProfesorListaAlumnoDTO {

	private Profesor profesor;
	private List<Alumno> lstAlumno;
	
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public List<Alumno> getLstAlumno() {
		return lstAlumno;
	}
	public void setLstAlumno(List<Alumno> lstAlumno) {
		this.lstAlumno = lstAlumno;
	}
	
	
	
		
}
