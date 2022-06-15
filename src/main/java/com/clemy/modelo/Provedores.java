package com.clemy.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Provedores  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdProvedores;
	
	private String NombreEmpresa;
	
	private String NombreRepre;
	
	private String ApellidoRepre; 
	
	private int Telefono; 
	
    private String Estado;
    
    

           
  //____________________________//

	public int getIdProvedores() {
		return IdProvedores;
	}


	public void setIdProvedores(int idProvedores) {
		IdProvedores = idProvedores;
	}


	public String getNombreEmpresa() {
		return NombreEmpresa;
	}


	public void setNombreEmpresa(String nombreEmpresa) {
		NombreEmpresa = nombreEmpresa;
	}


	public String getNombreRepre() {
		return NombreRepre;
	}


	public void setNombreRepre(String nombreRepre) {
		NombreRepre = nombreRepre;
	}


	public String getApellidoRepre() {
		return ApellidoRepre;
	}


	public void setApellidoRepre(String apellidoRepre) {
		ApellidoRepre = apellidoRepre;
	}


	public int getTelefono() {
		return Telefono;
	}


	public void setTelefono(int telefono) {
		Telefono = telefono;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}

	public Provedores() {
		super();
	}


	public Provedores(int idProvedores, String nombreEmpresa, String nombreRepre, String apellidoRepre, int telefono,
			String estado) {
		super();
		IdProvedores = idProvedores;
		NombreEmpresa = nombreEmpresa;
		NombreRepre = nombreRepre;
		ApellidoRepre = apellidoRepre;
		Telefono = telefono;
		Estado = estado;
	}


	public Provedores(String nombreEmpresa, String nombreRepre, String apellidoRepre, int telefono, String estado
			) {
		super();
		NombreEmpresa = nombreEmpresa;
		NombreRepre = nombreRepre;
		ApellidoRepre = apellidoRepre;
		Telefono = telefono;
		Estado = estado;
	}




	@Override
	public String toString() {
		return  NombreEmpresa;
	}


	public Provedores(String nombreEmpresa) {
		super();
		NombreEmpresa = nombreEmpresa;
	}
	
	





    
    

}
