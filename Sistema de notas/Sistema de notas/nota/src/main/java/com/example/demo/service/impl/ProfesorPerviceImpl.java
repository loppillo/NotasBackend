package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ModeloNotFoundException;
import com.example.demo.model.Profesor;
import com.example.demo.repository.ProfesorRepository;
import com.example.demo.service.ProfesorService;

@Service
public class ProfesorPerviceImpl implements ProfesorService {
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Override
	public Profesor findById(Integer id) throws Exception {
		Optional<Profesor> op = profesorRepository.findById(id);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id);
		}
		return op.get();
		}
	

	@Override
	public List<Profesor> findAll() {
		
		return profesorRepository.findAll();
	}

	@Override
	public Profesor save(Profesor profesor) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Profesor>> violations = validator.validate(profesor);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        Profesor prof = profesorRepository.save(profesor);
        return prof;
	}

	@Override
	public Profesor update(Profesor obj) {
		return profesorRepository.save(obj);
	}

	@Override
	public boolean deleteById(Integer id) {
		Optional<Profesor> op = profesorRepository.findById(id);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id);
		}
		profesorRepository.deleteById(id);
		return true;
	}


	@Override
	public Page<Profesor> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return profesorRepository.findAll(pageable);
	}
	

}
