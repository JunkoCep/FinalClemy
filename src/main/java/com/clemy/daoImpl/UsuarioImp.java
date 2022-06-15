package com.clemy.daoImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.clemy.Repository.UsuarioRepository;
import com.clemy.dao.UsuarioServicio;
import com.clemy.modelo.Usuario;



@Service
public class UsuarioImp implements UsuarioServicio{
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	@Override
	public List<Usuario> BuscarTodos() {
		
		return usuarioRepositorio.findAll();
	}

	@Override
	public void crearUsuario(Usuario usuario) {
		Usuario usu=usuarioRepositorio.save(usuario);
		if(!usu.equals(null)) {
		}
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
	 public void  updateResetPasswordToken(String token, String email) throws UsuarioNotFoundException {
		 
		 Usuario usuario =  usuarioRepositorio.findByEmail(email);
		 
		 if(usuario != null) {
			 usuario.setResetPasswordToken(token);
			 usuarioRepositorio.save(usuario);
		 } else {
			 
			 throw new UsuarioNotFoundException("No se enconntro ningun usuario asosciado a este correo electronico " + email);
		 }
	 }
	 
	 public Usuario get(String resetPasswordToken) {
		 return usuarioRepositorio.findByResetPasswordToken(resetPasswordToken);
	 }
     public void updatePassword(Usuario usuario, String newPassword) {
    	 BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
    	 String encodedPassword = passwordEncoder.encode(newPassword);
    	 usuario.setPassword(encodedPassword);
    	 usuario.setResetPasswordToken(null);
    	 usuarioRepositorio.save(usuario);
   
     }
     
     public static String getSiteURL(HttpServletRequest request) {
    	 String siteURL = request.getRequestURL().toString();
    	 return siteURL.replace(request.getServletPath(),"");
    	 
     }

	public Usuario getByResetPasswordToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}
}
