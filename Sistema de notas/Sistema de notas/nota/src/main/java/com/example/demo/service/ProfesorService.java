package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Profesor;

public interface ProfesorService extends ICrud<Profesor>{
	Page<Profesor> listarPageable(Pageable pageable);
}
