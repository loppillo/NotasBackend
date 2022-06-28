package com.example.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información o propiedades de Profesor")

@Entity
@Table(name="Profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_profesor;
	

	@Column(name="NombreProfesor" , length = 30)
	private String NombreProfesor;
	

	@Column(name="ApellidoProfesor", length = 30)
	private String ApellidoProfesor;
	
	@Column(name="ProfesorJefe")
	private Boolean ProfesorJefe;

	public Integer getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(Integer id_profesor) {
		this.id_profesor = id_profesor;
	}

	public String getNombreProfesor() {
		return NombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		NombreProfesor = nombreProfesor;
	}

	public String getApellidoProfesor() {
		return ApellidoProfesor;
	}

	public void setApellidoProfesor(String apellidoProfesor) {
		ApellidoProfesor = apellidoProfesor;
	}

	public Boolean getProfesorJefe() {
		return ProfesorJefe;
	}

	public void setProfesorJefe(Boolean profesorJefe) {
		ProfesorJefe = profesorJefe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ApellidoProfesor == null) ? 0 : ApellidoProfesor.hashCode());
		result = prime * result + ((NombreProfesor == null) ? 0 : NombreProfesor.hashCode());
		result = prime * result + ((ProfesorJefe == null) ? 0 : ProfesorJefe.hashCode());
		result = prime * result + ((id_profesor == null) ? 0 : id_profesor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (ApellidoProfesor == null) {
			if (other.ApellidoProfesor != null)
				return false;
		} else if (!ApellidoProfesor.equals(other.ApellidoProfesor))
			return false;
		if (NombreProfesor == null) {
			if (other.NombreProfesor != null)
				return false;
		} else if (!NombreProfesor.equals(other.NombreProfesor))
			return false;
		if (ProfesorJefe == null) {
			if (other.ProfesorJefe != null)
				return false;
		} else if (!ProfesorJefe.equals(other.ProfesorJefe))
			return false;
		if (id_profesor == null) {
			if (other.id_profesor != null)
				return false;
		} else if (!id_profesor.equals(other.id_profesor))
			return false;
		return true;
	}
	
	

	
	
	

}
