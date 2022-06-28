package com.example.demo.service.impl;

import java.util.ArrayList;
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
import com.example.demo.model.Menu;
import com.example.demo.repository.MenuRepository;
import com.example.demo.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public Menu save(Menu menu) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Menu>> violations = validator.validate(menu);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        Menu men = menuRepository.save(menu);
        return men;
	}
	
	@Override
	public Menu update(Menu menu) {
		return menuRepository.save(menu);
	}
	
	@Override
	public boolean deleteById(Integer idMenu) {
		Optional<Menu> op = menuRepository.findById(idMenu);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + idMenu);
		}
		menuRepository.deleteById(idMenu);
		return true;
	}
	
	@Override
	public Menu findById(Integer idMenu) {
		Optional<Menu> op = menuRepository.findById(idMenu);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + idMenu);
		}
		return op.get();
	}
	
	@Override
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		List<Menu> menus = new ArrayList<>();
		menuRepository.listarMenuPorUsuario(nombre).forEach(x -> {
			Menu m = new Menu();
			m.setIdMenu((Integer.parseInt(String.valueOf(x[0]))));
			m.setIcono(String.valueOf(x[1]));
			m.setNombre(String.valueOf(x[2]));
			m.setUrl(String.valueOf(x[3]));
			
			menus.add(m);
		});
		return menus;
	}
	
	

}
