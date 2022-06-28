package com.example.demo.controller;

import java.util.ArrayList;
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
import com.example.demo.service.AlumnoService;
import com.example.demo.dto.AlumnoDTO;
import com.example.demo.model.Alumno;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;




@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	@Autowired
	private AlumnoService alumnoService;
	
	@ApiOperation(value = "Obtener todos los alumnos",
			notes = "No necesita parametros de entrada",
			response = List.class,
			responseContainer = "Alumnos")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontraron alumnos en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
		
	
	@GetMapping
	public List<Alumno> findAll(){
		return alumnoService.findAll();
		
	}
	
	@ApiOperation(value = "Obtener un alumno",
			notes = "Necesita la id del alumno",
			response = List.class,
			responseContainer = "Alumnos")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontro alumno en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
		
	
	@GetMapping("/{id}")
	public Alumno findById(@PathVariable("id") Integer id) throws Exception{
		return alumnoService.findById(id);
		
	}
	
	
	@ApiOperation(value = "Guardar un alumno",
			notes = "Para guardar un alumno se necesita especificar la lista de un alumno mas una lista completa de una "
					+ "asistencia, y una lista completa de curso",
			response = List.class,
			responseContainer = "Alumnos")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se guardo alumno correctamente en la BD"),
				@ApiResponse(code = 200, message = "Se guardó alumno de forma correcta")})
		
	
	 @PostMapping
	 public Alumno save(@RequestBody Alumno alumno){
	        return alumnoService.save(alumno);
	    }

	
	@ApiOperation(value = "Actualizar un alumno",
			notes = "Para actualizar un alumno se necesita especificar la lista de un alumno mas una lista completa de una "
					+ "asistencia, y una lista completa de curso",
			response = List.class,
			responseContainer = "Alumnos")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se actualizo alumno"),
				@ApiResponse(code = 200, message = "Alumno actualizado correctamente")})
		
     @PutMapping
	 public Alumno update(@RequestBody Alumno alumno){
	        return alumnoService.update(alumno);
	    }

	
	
	@ApiOperation(value = "Eliminar alumno por un id",
			notes = "Para poder eliminar un alumno se necesita especificar el id del alumno a eliminar",
			response = List.class,
			responseContainer = "Alumnos")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se elimino el alumno"),
				@ApiResponse(code = 200, message = "Alumno eliminado correctamente")})
		
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
    		alumnoService.deleteById(id);
    		return null;
	    }
	
	@GetMapping("/ejemplo")
	private List<AlumnoDTO> getAlumnoDTO() throws Exception{
		return alumnoService.getAlumnosDTO();
		
	}
	
	
}
