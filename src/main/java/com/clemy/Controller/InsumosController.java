package com.clemy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clemy.Repository.InsumosRepository;
import com.clemy.Repository.ProvedorRepository;
import com.clemy.Repository.UnidadMedidaRepository;
import com.clemy.modelo.Insumos;
import com.clemy.modelo.Provedores;
import com.clemy.modelo.UnidadesMedida;



@Controller
public class InsumosController {
	
	@Autowired
	private InsumosRepository insumosRepository;
	
	@Autowired
	private ProvedorRepository provedorRepository;
	
	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;
	
	@GetMapping("/Insumos")
	public String listarInsumos(Model modelo) {
		List<Insumos> listaInsumos = insumosRepository.findAll();
		modelo.addAttribute("listaInsumos", listaInsumos);
		return "Admin/Insumos";
	}
	@GetMapping("/Insumos/nuevo")
	public String nuevoInsumo(Model modelo) {
		List<Provedores> listaProvedores= provedorRepository.findAll();
		List<UnidadesMedida> listauni= unidadMedidaRepository.findAll();
		modelo.addAttribute("insumos",new Insumos());
		modelo.addAttribute("listaProvedores",listaProvedores); 
		modelo.addAttribute("listauni",listauni); 
 		return"Admin/agregarInsumos";
	}
	
	@PostMapping("/Insumos/guardar")
	public String guardarInsumos(Insumos insumos) {
		insumosRepository.save(insumos);
		return "redirect:/Insumos";
		
	}
	

	@GetMapping("/Insumos/editar/{IdInsumo}")
	public String EditarInsumos(@PathVariable("IdInsumo")Integer IdInsumo, Model modelo) {
		Insumos insumos= insumosRepository.findById(IdInsumo).get();
		List<Provedores> listaProvedores= provedorRepository.findAll();
		List<UnidadesMedida> listauni= unidadMedidaRepository.findAll();
		modelo.addAttribute("insumos",insumos);
		modelo.addAttribute("listaProvedores",listaProvedores); 
		modelo.addAttribute("listauni",listauni); 
		return"Admin/agregarInsumos";
		
	}

	@GetMapping("/Insumos/eliminar/{IdInsumo}")
	public String EliminarInsumo(@PathVariable("IdInsumo")Integer IdInsumo, Model modelo) {
        insumosRepository.deleteById(IdInsumo);
		return "redirect:/Insumos";
	}
}
