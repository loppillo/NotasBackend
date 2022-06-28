package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Profesor;
import com.example.demo.service.ProfesorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

	private ProfesorService profesorService;

	@Autowired
	public ProfesorController(ProfesorService profesorService) {
		this.profesorService = profesorService;
	}
	
	@ApiOperation(value = "Obtener todos los profesores",
			notes = "No necesita parametros de entrada",
			response = List.class,
			responseContainer = "Profesor")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontraron profesores en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
	
	@GetMapping
	public List<Profesor> findAll(){
		return profesorService.findAll();
		
	}
	
	@ApiOperation(value = "Obtener un profesor",
			notes = "Necesita la id del profesor",
			response = List.class,
			responseContainer = "Profesor")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontro profesor en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
	
	
	
	@GetMapping("/{id}")
	public Profesor findById(@PathVariable("id") Integer id) throws Exception{
		return profesorService.findById(id);
		
	}
	
	@ApiOperation(value = "Guardar un profesor",
			notes = "Para guardar un profesor se necesita especificar la lista de un profesor",
			response = List.class,
			responseContainer = "Profesor")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se guardó profesor correctamente en la BD"),
				@ApiResponse(code = 200, message = "Se guardó profesor de forma correcta")})
	
	 @PostMapping
	 public Profesor save(@RequestBody Profesor profesor){
	        return profesorService.save(profesor);
	    }

	@ApiOperation(value = "Actualizar un profesor",
			notes = "Para actualizar un profesor se necesita especificar la lista de un profesor",
			response = List.class,
			responseContainer = "Profesor")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se actualizo profesor"),
				@ApiResponse(code = 200, message = "Profesor actualizado correctamente")})
	
     @PutMapping
	 public Profesor update(@RequestBody Profesor profesor){
	        return profesorService.update(profesor);
	    }
	
	@ApiOperation(value = "Eliminar profesor por id",
 			notes = "Para poder eliminar un profesor se necesita especificar el id del profesor a eliminar",
 			response = List.class,
 			responseContainer = "Profesor")
 			@ApiResponses(value = {
 				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
 				@ApiResponse(code = 404, message = "Not found, no encontrado"),
 				@ApiResponse(code = 405, message = "No se elimino el profesor"),
 				@ApiResponse(code = 200, message = "Profesor eliminado correctamente")})

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        profesorService.deleteById(id);
        return null;
	    }
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Profesor>> listarPageable(Pageable pageable){
		Page<Profesor> profesores = profesorService.listarPageable(pageable);
		return new ResponseEntity<Page<Profesor>>(profesores,HttpStatus.OK);
		
		
	}
	
}
