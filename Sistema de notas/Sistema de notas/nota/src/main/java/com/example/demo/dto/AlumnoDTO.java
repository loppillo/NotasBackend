package com.example.demo.dto;



import java.io.Serializable;

import com.example.demo.model.Asistencia;
import com.example.demo.model.Curso;

public class AlumnoDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private  Integer id_alumno;
	private Asistencia asistencia;
	private Curso curso;
	
	public Integer getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(Integer id_alumno) {
		this.id_alumno = id_alumno;
	}
	public Asistencia getAsistencia() {
		return asistencia;
	}
	public void setAsistencia(Asistencia asistencia) {
		this.asistencia = asistencia;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
