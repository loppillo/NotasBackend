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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ModeloNotFoundException;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UserDetailsService,UsuarioService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario findById(Integer id){
		Optional<Usuario> op = usuarioRepository.findById(id);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id);
		}
		return op.get();	
		}

	@Override
	public List<Usuario> findAll() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario save(Usuario usuario) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        Usuario user = usuarioRepository.save(usuario);
        return user;
	}

	@Override
	public Usuario update(Usuario obj) {
		
		return usuarioRepository.save(obj);
	}

	@Override
	public boolean deleteById(Integer id){
		Optional<Usuario> op = usuarioRepository.findById(id);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id);
		}
		usuarioRepository.deleteById(id);
		return true;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findOneByUserName(username);
		if(usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		List<GrantedAuthority> roles = new ArrayList<>();
		usuario.getRols().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		UserDetails ud = new User(usuario.getUserName(), usuario.getPassword(), roles);
		return ud;
	}
	

}
