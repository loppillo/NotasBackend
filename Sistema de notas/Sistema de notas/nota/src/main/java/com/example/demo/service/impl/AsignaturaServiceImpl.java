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
import org.springframework.stereotype.Service;
import com.example.demo.exception.ModeloNotFoundException;
import com.example.demo.model.Asignatura;
import com.example.demo.repository.AsignaturaRepository;
import com.example.demo.service.AsignaturaService;

@Service
public class AsignaturaServiceImpl 	implements AsignaturaService{
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	public Asignatura findById(Integer id_asignatura)  {
		Optional<Asignatura> op = asignaturaRepository.findById(id_asignatura);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id_asignatura);
		}
		return op.get();

	}

	@Override
	public List<Asignatura> findAll() {
		return asignaturaRepository.findAll();
	}

	@Override
	public Asignatura save(Asignatura asignatura) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Asignatura>> violations = validator.validate(asignatura);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
       
        Asignatura asig = asignaturaRepository.save(asignatura);
        return asig;
	}

	@Override
	public Asignatura update(Asignatura asignatura) {
		return asignaturaRepository.save(asignatura);
	}

	@Override
	public boolean deleteById(Integer id_asignatura) throws Exception {
		Optional<Asignatura> op = asignaturaRepository.findById(id_asignatura);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id_asignatura);
		}
		asignaturaRepository.deleteById(id_asignatura);
		return true;
	}

	
	
}
