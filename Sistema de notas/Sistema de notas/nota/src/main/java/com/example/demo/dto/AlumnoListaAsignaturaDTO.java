package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Alumno;
import com.example.demo.model.Asignatura;

public class AlumnoListaAsignaturaDTO {
	
	private Alumno alumno;
	private List<Asignatura> lstAsignatura;
	
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public List<Asignatura> getLstAsignatura() {
		return lstAsignatura;
	}
	public void setLstAsignatura(List<Asignatura> lstAsignatura) {
		this.lstAsignatura = lstAsignatura;
	}
	
}
