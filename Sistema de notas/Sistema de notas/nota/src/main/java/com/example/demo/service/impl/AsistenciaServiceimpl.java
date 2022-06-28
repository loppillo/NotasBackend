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
import com.example.demo.model.Asistencia;
import com.example.demo.repository.AsistenciaRepository;
import com.example.demo.service.AsistenciaService;

@Service
public class AsistenciaServiceimpl  implements AsistenciaService{
	
	@Autowired
	private AsistenciaRepository asistenciaRepository;
	
	@Override
	public Asistencia findById(Integer id_asistencia) throws Exception {
		Optional<Asistencia> op = asistenciaRepository.findById(id_asistencia);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id_asistencia);
		}
		return op.get();
		
	}

	@Override
	public List<Asistencia> findAll() {
		return asistenciaRepository.findAll();
	}

	@Override
	public Asistencia save(Asistencia asistencia) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Asistencia>> violations = validator.validate(asistencia);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        Asistencia asis = asistenciaRepository.save(asistencia);
        return asis;
		
	}

	@Override
	public Asistencia update(Asistencia asistencia) {

		return asistenciaRepository.save(asistencia);
	}

	@Override
	public boolean deleteById(Integer id_asistencia){
		Optional<Asistencia> op = asistenciaRepository.findById(id_asistencia);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id_asistencia);
		}
		asistenciaRepository.deleteById(id_asistencia);
		return true;
	}

	
	
}
