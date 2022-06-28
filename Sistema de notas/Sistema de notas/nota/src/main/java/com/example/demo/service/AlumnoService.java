package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AlumnoDTO;
import com.example.demo.model.Alumno;

public interface AlumnoService extends ICrud<Alumno> {

	List<AlumnoDTO> getAlumnosDTO() throws Exception;
	
	
	
	
}
