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
import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import com.example.demo.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Curso findById(Integer id_curso) throws Exception {
		Optional<Curso> op = cursoRepository.findById(id_curso);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id_curso);
		}
		return op.get();
	}

	@Override
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso save(Curso curso) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Curso>> violations = validator.validate(curso);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        Curso cur = cursoRepository.save(curso);
        return cur;
	}

	@Override
	public Curso update(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public boolean deleteById(Integer id_curso) throws Exception {
		Optional<Curso> op = cursoRepository.findById(id_curso);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id_curso);
		}
		cursoRepository.deleteById(id_curso);
		return true;
	}

	
	
}
