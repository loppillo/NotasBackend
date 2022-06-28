package com.example.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(description = "Información o propiedes del alumno")


@Entity
@Table(name="alumno")
public class Alumno {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_alumno;
	

	@Column(name="Rut", length = 10)
	private String Rut;
	

	

	@Column(name="Nombre1", length = 30)
	private String Nombre1;
	
	
	

	@Column(name="Nombre2", length = 30)
	private String Nombre2;
	
	
	

	@Column(name="Apellido1", length = 30)
	private String Apellido1;
	

	

	@Column(name="Apellido2", length = 30)
	private String Apellido2;


	@ManyToOne
    @JoinColumn(name = "id_asistencia", nullable = true, foreignKey = @ForeignKey(name = "FK_alumno_asistencia"))
    private Asistencia asistencia;
	 
	@ManyToOne
    @JoinColumn(name = "id_curso", nullable = true, foreignKey = @ForeignKey(name = "FK_alumno_curso"))
    private Curso curso;

	public Integer getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(Integer id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getRut() {
		return Rut;
	}

	public void setRut(String rut) {
		Rut = rut;
	}

	public String getNombre1() {
		return Nombre1;
	}

	public void setNombre1(String nombre1) {
		Nombre1 = nombre1;
	}

	public String getNombre2() {
		return Nombre2;
	}

	public void setNombre2(String nombre2) {
		Nombre2 = nombre2;
	}

	public String getApellido1() {
		return Apellido1;
	}

	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}

	public String getApellido2() {
		return Apellido2;
	}

	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido1 == null) ? 0 : Apellido1.hashCode());
		result = prime * result + ((Apellido2 == null) ? 0 : Apellido2.hashCode());
		result = prime * result + ((Nombre1 == null) ? 0 : Nombre1.hashCode());
		result = prime * result + ((Nombre2 == null) ? 0 : Nombre2.hashCode());
		result = prime * result + ((Rut == null) ? 0 : Rut.hashCode());
		result = prime * result + ((asistencia == null) ? 0 : asistencia.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((id_alumno == null) ? 0 : id_alumno.hashCode());
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
		Alumno other = (Alumno) obj;
		if (Apellido1 == null) {
			if (other.Apellido1 != null)
				return false;
		} else if (!Apellido1.equals(other.Apellido1))
			return false;
		if (Apellido2 == null) {
			if (other.Apellido2 != null)
				return false;
		} else if (!Apellido2.equals(other.Apellido2))
			return false;
		if (Nombre1 == null) {
			if (other.Nombre1 != null)
				return false;
		} else if (!Nombre1.equals(other.Nombre1))
			return false;
		if (Nombre2 == null) {
			if (other.Nombre2 != null)
				return false;
		} else if (!Nombre2.equals(other.Nombre2))
			return false;
		if (Rut == null) {
			if (other.Rut != null)
				return false;
		} else if (!Rut.equals(other.Rut))
			return false;
		if (asistencia == null) {
			if (other.asistencia != null)
				return false;
		} else if (!asistencia.equals(other.asistencia))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (id_alumno == null) {
			if (other.id_alumno != null)
				return false;
		} else if (!id_alumno.equals(other.id_alumno))
			return false;
		return true;
	}

	
	
	
}
