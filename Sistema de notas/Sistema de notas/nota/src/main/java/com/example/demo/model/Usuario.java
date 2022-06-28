package com.example.demo.model;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;

import io.swagger.annotations.ApiModel;


@ApiModel(description = "Información o propiedades de Usuario")

@Entity
@Table(name="usuario")
public class Usuario {
		
		public Usuario() {}
	
	
		public Usuario(Integer idUsuario, String password, List<Rol> rols) {
			this.idUsuario = idUsuario;
			this.password = password;
			this.rols = rols;
			
		}


		@Id
	    private Integer idUsuario;

	 	@Size(min=10,max=20,message="El Nombre De Usuario debe ser igual o mayor de 10 y menor o igual de 250")	
	    @Column(name = "nombre", length = 255)
	    private String userName;

	 	@Size(min=10,max=25,message="El password debe ser igual o mayor de 10 y menor o igual de 250")
	    @Column(name = "clave", length = 255)
	    private String password;

	 	
	    @Column(name = "estado")
	    private boolean estado;

	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	            name = "usuario_rol",
	            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"),
	            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	    private List<Rol> rols;

		
		public Integer getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Integer idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

		public List<Rol> getRols() {
			return rols;
		}

		public void setRols(List<Rol> rols) {
			this.rols = rols;
		}

		
		
	
}
