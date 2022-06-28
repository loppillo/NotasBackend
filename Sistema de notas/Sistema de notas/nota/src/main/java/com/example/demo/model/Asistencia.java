package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información o propiedades de una asistencia")


@Entity
@Table(name="Asistencia")
public class Asistencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_asistencia;
	
	@Min(value = 1, message = "El minimo de dias trabajados debe ser igual o mayor a 1")
    @Max(value = 20, message = "El maximo de los dias trabajados debe ser igual o menor de 20")
	@Column(name="dias_trabajados", length = 20)
	private Integer dias_trabajados;
	
	@Min(value = 1, message = "El minimo de dias trabajados debe ser igual o mayor a 1")
    @Max(value = 20, message = "El maximo de los dias trabajados debe ser igual o menor de 20")
	@Column(name="dias_asistidos", length = 20)
	private Integer dias_asistidos;
	
	@Size(min=2,max=20,message="La asistencia total deben ser igual o mayor de 2 y menor o igual a 20")
	@Column(name="asistencia_total", length = 20)
	private String asistencia_total;
	
	@OneToMany(mappedBy = "asistencia", cascade = { CascadeType.ALL }, orphanRemoval = true)
	    private List<Alumno> alumno;
	
	public Integer getId_asistencia() {
		return id_asistencia;
	}

	public void setId_asistencia(Integer id_asistencia) {
		this.id_asistencia = id_asistencia;
	}

	public Integer getDias_trabajados() {
		return dias_trabajados;
	}

	public void setDias_trabajados(Integer dias_trabajados) {
		this.dias_trabajados = dias_trabajados;
	}

	public Integer getDias_asistidos() {
		return dias_asistidos;
	}

	public void setDias_asistidos(Integer dias_asistidos) {
		this.dias_asistidos = dias_asistidos;
	}

	public String getAsistencia_total() {
		return asistencia_total;
	}

	public void setAsistencia_total(String asistencia_total) {
		this.asistencia_total = asistencia_total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((asistencia_total == null) ? 0 : asistencia_total.hashCode());
		result = prime * result + ((dias_asistidos == null) ? 0 : dias_asistidos.hashCode());
		result = prime * result + ((dias_trabajados == null) ? 0 : dias_trabajados.hashCode());
		result = prime * result + ((id_asistencia == null) ? 0 : id_asistencia.hashCode());
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
		Asistencia other = (Asistencia) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (asistencia_total == null) {
			if (other.asistencia_total != null)
				return false;
		} else if (!asistencia_total.equals(other.asistencia_total))
			return false;
		if (dias_asistidos == null) {
			if (other.dias_asistidos != null)
				return false;
		} else if (!dias_asistidos.equals(other.dias_asistidos))
			return false;
		if (dias_trabajados == null) {
			if (other.dias_trabajados != null)
				return false;
		} else if (!dias_trabajados.equals(other.dias_trabajados))
			return false;
		if (id_asistencia == null) {
			if (other.id_asistencia != null)
				return false;
		} else if (!id_asistencia.equals(other.id_asistencia))
			return false;
		return true;
	}
	
	
	
}
