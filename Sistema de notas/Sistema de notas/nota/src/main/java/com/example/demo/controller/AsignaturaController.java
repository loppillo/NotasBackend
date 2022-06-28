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
import com.example.demo.model.Asignatura;
import com.example.demo.service.AsignaturaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
	@Autowired
	private AsignaturaService asignaturaService;
	
	
	@ApiOperation(value = "Obtener todos las asignaturas",
			notes = "No necesita parametros de entrada",
			response = List.class,
			responseContainer = "Asignatura")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontraron asignaturas en la bd"),
				@ApiResponse(code = 200, message = "Petición OK")})
		
	
	@GetMapping
	public List<Asignatura> findAll(){
		return asignaturaService.findAll();
		
	}
	
	@ApiOperation(value = "Obtener una asignatura",
			notes = "Necesita la id de la asignatura que se desea buscar",
			response = List.class,
			responseContainer = "Asignatura")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontro asignatura en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
	
	
	
	@GetMapping("/{id}")
	public Asignatura findById(@PathVariable("id") Integer id) throws Exception{
		return asignaturaService.findById(id);
		
	}
	
	@ApiOperation(value = "Guardar una asignatura",
			notes = "Para guardar una asignatura hay que introducir los datos",
			response = List.class,
			responseContainer = "Asignatura")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se guardo asignatura correctamente en la BD"),
				@ApiResponse(code = 200, message = "Se guardó asignatura de forma correcta")})
	
	 @PostMapping
	 public Asignatura save(@RequestBody Asignatura asignatura){
	        return asignaturaService.save(asignatura);
	    }

	
	@ApiOperation(value = "Actualizar una asignatura",
			notes = "Para actualizar una asignatura se necesita especificar la lista de una asignatura",
			response = List.class,
			responseContainer = "Asignatura")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se actualizo asignatura"),
				@ApiResponse(code = 200, message = "Asignatura actualizada correctamente")})
	
	
	
     @PutMapping
	 public Asignatura update(@RequestBody Asignatura asignatura){
	        return asignaturaService.update(asignatura);
	    }

	@ApiOperation(value = "Eliminar asignatura por id",
			notes = "Para poder eliminar una asignatura se necesita especificar el id de la asignatura a eliminar",
			response = List.class,
			responseContainer = "Asignatura")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se elimino la asignatura"),
				@ApiResponse(code = 200, message = "Asignatura eliminada correctamente")})
		
	
	
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        asignaturaService.deleteById(id);
        return null;
	    }
	
	
	
	
	
}
