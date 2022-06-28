package com.example.demo.service;

import java.util.List;

public interface ICrud <E>{
	//Metodos plantilla
	 E findById(Integer id) throws Exception;
	    List<E> findAll();
	    E save(E e);
	    E update(E e);
	    boolean deleteById(Integer id) throws Exception;
	
	
	
}
