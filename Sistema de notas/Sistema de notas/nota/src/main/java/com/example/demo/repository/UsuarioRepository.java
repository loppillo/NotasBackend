package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	

	//select * from usuario where username = ?
		Usuario findOneByUserName(String username);
}
