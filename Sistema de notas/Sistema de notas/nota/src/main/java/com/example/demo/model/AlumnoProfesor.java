package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;



@ApiModel(description = "Información o propiedades del AlumnoProfesor")

@Entity
@Table(name = "AlumnoProfesor")
@IdClass(AlumnoProfesorPK.class)
public class AlumnoProfesor {

	@Id
    private Profesor profesor;

    @Id
    private Alumno alumno;


	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	
	
}
