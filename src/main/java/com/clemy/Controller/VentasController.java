package com.clemy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clemy.Repository.ClienteRepository;
import com.clemy.Repository.EnviosRepository;
import com.clemy.Repository.InventarioRepository;
import com.clemy.Repository.ProductosRepository;
import com.clemy.Repository.VendedorRepository;
import com.clemy.Repository.VentasRepository;
import com.clemy.modelo.Cliente;
import com.clemy.modelo.Envios;
import com.clemy.modelo.Inventario;
import com.clemy.modelo.Productos;
import com.clemy.modelo.Vendedor;
import com.clemy.modelo.Ventas;


@Controller
public class VentasController {
	

	
		@Autowired
		private ClienteRepository clienteRepository;
		
		
	    @Autowired
	    private VendedorRepository vendedorRepository;
	    
		@Autowired
		private ProductosRepository productosRepository;

	    
	    @Autowired
	    private InventarioRepository inventarioRepository;
	    

	    
	    @Autowired
	    private VentasRepository ventasRepository;
	    
	    @Autowired
	    private EnviosRepository enviosRepository;
	    
	    
		@GetMapping("/ventas")
		public String listarVentas(Model modelo) {
			List<Ventas>listarVentas= ventasRepository.findAll();
			modelo.addAttribute("listarVentas", listarVentas);
			return "Admin/Ventas";
			
		}
		
		@GetMapping("/ventas/nuevo")
		public String nuevaVenta(Model modelo) {
			List<Cliente>listaCliente = clienteRepository.findAll();
			List<Vendedor>listaVendedor = vendedorRepository.findAll();
			List<Inventario>listaInventario = inventarioRepository.findAll();
			List<Envios>listaEnvios = enviosRepository.findAll();
			List<Productos>listaProductos = productosRepository.findAll();
			modelo.addAttribute("Ventas",new Ventas());
			modelo.addAttribute("listaCliente", listaCliente);
			modelo.addAttribute("listaVendedor", listaVendedor);
			modelo.addAttribute("listaInventario", listaInventario);
			modelo.addAttribute("listaEnvios", listaEnvios);
			modelo.addAttribute("listaProductos", listaProductos);
			
	 		return"Admin/NuevoVenta";
		}
		@PostMapping("/ventas/guardar")
		public String guardarproductos(Ventas ventas) {
			ventasRepository.save(ventas);
			return "redirect:/ventas";
			
		}
		
		@GetMapping("/ventas/editar/{IdVenta}")
		public String EditarVenta(@PathVariable("IdVenta")Integer IdVenta, Model modelo) {
		    Ventas ventas = ventasRepository.findById(IdVenta).get();
			modelo.addAttribute("Ventas", ventas );
			List<Cliente>listaCliente = clienteRepository.findAll();
			List<Vendedor>listaVendedor = vendedorRepository.findAll();
			List<Inventario>listaInventario = inventarioRepository.findAll();
			List<Envios>listaEnvios = enviosRepository.findAll();
			List<Productos>listaProductos = productosRepository.findAll();
			modelo.addAttribute("listaCliente", listaCliente);
			modelo.addAttribute("listaVendedor", listaVendedor);
			modelo.addAttribute("listaInventario", listaInventario);
			modelo.addAttribute("listaEnvios", listaEnvios);
			modelo.addAttribute("listaProductos", listaProductos);
			
			return"Admin/NuevoVenta";
			
		}
		
		@GetMapping("/ventas/eliminar/{IdVenta}")
		public String EliminarInsumo(@PathVariable("IdVenta")Integer IdVenta, Model modelo) {
	           ventasRepository.deleteById(IdVenta);
			return "redirect:/ventas";
			
			
		}
		
}
