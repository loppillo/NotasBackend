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
import com.example.demo.model.Asistencia;
import com.example.demo.service.AsistenciaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;



@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {
	@Autowired
	private AsistenciaService asistenciaService;
	
	@ApiOperation(value = "Obtener todas las asistencias",
			notes = "No necesita parametros de entrada",
			response = List.class,
			responseContainer = "Asistencia")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontraron asistencias en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
	
	@GetMapping
	public List<Asistencia> findAll(){
		return asistenciaService.findAll();
		
	}
	
	@ApiOperation(value = "Obtener una asistencia",
			notes = "Necesita la id de la asistencia",
			response = List.class,
			responseContainer = "Asistencia")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontro asistencia en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
	
	
	@GetMapping("/{id}")
	public Asistencia findById(@PathVariable("id") Integer id) throws Exception{
		return asistenciaService.findById(id);
		
	}
	
	@ApiOperation(value = "Guardar una asistencia",
			notes = "Para guardar una asistencia se necesita especificar la lista de una asistencia",
			response = List.class,
			responseContainer = "Asistencia")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se guardo una asistencia correctamente en la BD"),
				@ApiResponse(code = 200, message = "Se guardó una asistencia de forma correcta")})
	
	 @PostMapping
	 public Asistencia save(@RequestBody Asistencia asistencia){
	        return asistenciaService.save(asistencia);
	    }

	@ApiOperation(value = "Actualizar una asistencia",
			notes = "Para actualizar una asistencia se necesita especificar la lista de una asistencia",
			response = List.class,
			responseContainer = "Asistencia")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se actualizo asistencia"),
				@ApiResponse(code = 200, message = "Asistencia actualizada correctamente")})
	
	
	
     @PutMapping
	 public Asistencia update(@RequestBody Asistencia asistencia){
	        return asistenciaService.update(asistencia);
	    }
	
	@ApiOperation(value = "Eliminar asistencia por id",
			notes = "Para poder eliminar una asistencia se necesita especificar el id de la asistencia a eliminar",
			response = List.class,
			responseContainer = "Asistencia")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se elimino la asistencia"),
				@ApiResponse(code = 200, message = "Asistencia eliminada correctamente")})
		
	
	
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        asistenciaService.deleteById(id);
        return null;
	    }
	
	
	
	
	
}
