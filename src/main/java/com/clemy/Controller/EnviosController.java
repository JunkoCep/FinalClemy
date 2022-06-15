package com.clemy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clemy.Repository.EnviosRepository;
import com.clemy.Repository.EstadoComprasRepository;
import com.clemy.Repository.VentasRepository;
import com.clemy.modelo.Envios;
import com.clemy.modelo.Ventas;
import com.clemy.modelo.estadocompras;



@Controller
public class EnviosController {
	
	@Autowired
	private EnviosRepository enviosRepository;
	
	@Autowired
    private EstadoComprasRepository estadoComprasRepository;
	
	@Autowired
	private VentasRepository ventasRepository;
	
	@GetMapping("/envios")
	public String listarEnvios(Model modelo) {
		List<Envios> listarEnvios = enviosRepository.findAll();
		modelo.addAttribute("listarEnvios",listarEnvios);	
		return"Admin/Envios";
	}
	
	@GetMapping("/envio/nuevo")
	public String nuevoEnvio(Model modelo) {
		List<estadocompras> listaestado = estadoComprasRepository.findAll();
		List<Ventas> listaVentas = ventasRepository.findAll();
		modelo.addAttribute("envios",new Envios());
		modelo.addAttribute("listaestado",listaestado);
		modelo.addAttribute("listaVentas",listaVentas);
		
 		return"Admin/NuevoEnvio";
	}
	
	@PostMapping("/envios/guardar")
	public String guardarproductos(Envios envios) {
		enviosRepository.save(envios);
		return "redirect:/envios";
		
	}
	@GetMapping("/envios/editar/{IdEnvio}")
	public String EditarProducto(@PathVariable("IdEnvio")Integer IdEnvio, Model modelo) {
		Envios envios = enviosRepository.findById(IdEnvio).get();
		List<estadocompras> listaestado = estadoComprasRepository.findAll();
		List<Ventas> listaVentas = ventasRepository.findAll();
		modelo.addAttribute("envios",envios );
		modelo.addAttribute("listaestado",listaestado);
		modelo.addAttribute("listaVentas",listaVentas);
		
		return"Admin/NuevoEnvio";
	}
}
