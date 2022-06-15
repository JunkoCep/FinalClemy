package com.clemy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clemy.Repository.ProvedorRepository;
import com.clemy.modelo.Provedores;




@Controller
public class ProvedoresController {
	
	@Autowired
	private ProvedorRepository provedorRepository;
	
	
	@GetMapping("/listaProvedores")
	public String listarProvedores(Model modelo) {
		List<Provedores> listarProvedores= provedorRepository.findAll();
		modelo.addAttribute("listaProvedores", listarProvedores);
		return "Admin/Provedores";
		
	}
	
	@GetMapping("/listaProvedores/nuevo")
	public String nuevoProvedor(Model modelo) {
		modelo.addAttribute("provedores", new Provedores());
		return "Admin/nuevoProvedor";
		
	}
	
	@PostMapping("/listaProvedores/guardar")
	public String guardarProvedor (Provedores provedores) {
		provedorRepository.save(provedores);
		return "redirect:/listaProvedores";
		
	}
	@GetMapping("/listaProvedores/editar/{IdProvedores}")
	public String EditarProvedor(@PathVariable("IdProvedores")Integer IdProvedores, Model modelo) {
		Provedores provedores = provedorRepository.findById(IdProvedores).get();
		modelo.addAttribute("provedores", provedores);
		return"Admin/nuevoProvedor";
	}
	@GetMapping("/listarProvedores/eliminar/{IdProvedores}")
	public String EliminarUsuario(@PathVariable("IdProvedores")Integer IdProvedores , Model modelo) {
		provedorRepository.deleteById(IdProvedores);
		return "redirect:/provedores";
	}	
	
}
