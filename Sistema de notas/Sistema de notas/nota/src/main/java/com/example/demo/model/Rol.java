package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información o propiedades de Rol")

@Entity
@Table(name = "rol")
public class Rol {
	
	    @Id
	    private Integer idRol;
	    
	    @Size(min=8,max=20,message="El Nombre Del Rol debe ser igual o mayor de 8 y menor o igual a 40")	
	    @Column(name = "nombre", length = 40)
	    private String nombre;

		public Integer getIdRol() {
			return idRol;
		}

		public void setIdRol(Integer idRol) {
			this.idRol = idRol;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		
		
	    
	    
	    

}
