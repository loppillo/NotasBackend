package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información o propiedades del AlumnoAsignatura")


@Entity
@Table(name="alumno_asignatura")
@IdClass(AlumnoAsignaturaPk.class)
public class AlumnoAsignatura {

	@Id
	private Alumno alumno;
	
	@Id
	private Asignatura asignatura;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	
	
}
