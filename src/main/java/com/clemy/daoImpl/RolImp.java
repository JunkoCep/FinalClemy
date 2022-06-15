package com.clemy.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clemy.Repository.RolRepository;
import com.clemy.dao.RolServicio;
import com.clemy.modelo.Rol;

@Service
public class RolImp implements RolServicio {
	@Autowired
	private RolRepository rolRepositorio;

	@Override
	public List<Rol> BuscarTodos() {

		return rolRepositorio.findAll();
	}

	@Override
	public void crearRol(Rol rol) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarRol(Rol rol) {
		// TODO Auto-generated method stub

	}

}
