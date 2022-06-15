package com.clemy.dao;
import java.util.List;

import com.clemy.modelo.Rol;


public interface RolServicio {
public List<Rol> BuscarTodos();
	
	public void crearRol(Rol rol);
		
	public void actualizarRol(Rol rol);
	
}
