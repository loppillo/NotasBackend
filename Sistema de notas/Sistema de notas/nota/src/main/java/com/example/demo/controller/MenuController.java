package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Menu;
import com.example.demo.service.MenuService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/menus")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@ApiOperation(value = "Obtener la lista de menu",
			notes = "No necesita parametros de entrada",
			response = List.class,
			responseContainer = "Alumnos")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se esncontró la lista de menu en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menues = new ArrayList<>();
		menues = menuService.findAll();
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Obtener lista de menu por usuario",
			notes = "No necesita parametros de entrada",
			response = List.class,
			responseContainer = "Alumnos")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se esncontró la lista de menu por usuario en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
	
	
	
	@PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar(@RequestBody String nombre) {
		List<Menu> menus = new ArrayList<>();
		menus = menuService.listarMenuPorUsuario(nombre);
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}
}
