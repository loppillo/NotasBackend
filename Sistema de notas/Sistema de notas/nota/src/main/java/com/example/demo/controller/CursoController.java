package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Curso;
import com.example.demo.service.CursoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/curso")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	
	@ApiOperation(value = "Obtener todos los cursos",
			notes = "No necesita parametros de entrada",
			response = List.class,
			responseContainer = "Curso")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontraron cursos en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
	
	
	@GetMapping
	public List<Curso> findAll(){
		return cursoService.findAll();
		
	}
	
	@ApiOperation(value = "Obtener un curso",
			notes = "Se necesita la id del curso",
			response = List.class,
			responseContainer = "Curso")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontro curso en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
	
	
	@GetMapping("/{id}")
	public Curso findById(@PathVariable("id") Integer id_curso) throws Exception{
		return cursoService.findById(id_curso);
		
	}
	
	@ApiOperation(value = "Guardar un curso",
			notes = "Para guardar un curso se necesita especificar la lista de un curso",
			response = List.class,
			responseContainer = "Alumnos")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se guardo curso correctamente en la BD"),
				@ApiResponse(code = 200, message = "Se guardó un curso de forma correcta")})
	
	 @PostMapping
	 public Curso save(@RequestBody Curso curso){
	        return cursoService.save(curso);
	    }
	 
	 @ApiOperation(value = "Actualizar un curso",
				notes = "Para actualizar un curso se necesita especificar la lista de un curso",
				response = List.class,
				responseContainer = "Alumnos")
				@ApiResponses(value = {
					@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
					@ApiResponse(code = 404, message = "Not found, no encontrado"),
					@ApiResponse(code = 405, message = "No se actualizo curso"),
					@ApiResponse(code = 200, message = "Curso actualizado correctamente")})

     @PutMapping
	 public Curso update(@RequestBody Curso curso){
	        return cursoService.update(curso);
	    }
     
     @ApiOperation(value = "Eliminar alumno por un id",
 			notes = "Para poder eliminar un curso se necesita especificar el id del curso a eliminar",
 			response = List.class,
 			responseContainer = "Curso")
 			@ApiResponses(value = {
 				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
 				@ApiResponse(code = 404, message = "Not found, no encontrado"),
 				@ApiResponse(code = 405, message = "No se elimino el curso"),
 				@ApiResponse(code = 200, message = "Curso eliminado correctamente")})
 		
     
     
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id_curso) throws Exception {
        cursoService.deleteById(id_curso);
        return null;
	    }
	
	
	
	
	
}
