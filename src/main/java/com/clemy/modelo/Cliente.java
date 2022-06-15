package com.clemy.modelo;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCliente;
	
	private String NombreCliente;
	

	 @ManyToOne(fetch = FetchType.EAGER)
	    private Usuario usuarios; 
	 

	 
	//____________________________//

	 
	public int getIdCliente() {
		return IdCliente;
	}

	public String getNombreCliente() {
		return NombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	public Integer toInteger() {
		return  IdCliente ;
	}

	@Override
	public String toString() {
		return  NombreCliente;
	}

	
	 
}
