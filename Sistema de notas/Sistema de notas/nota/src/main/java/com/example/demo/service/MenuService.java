package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Menu;

public interface MenuService extends ICrud<Menu>{

	List<Menu> listarMenuPorUsuario(String nombre);
}
