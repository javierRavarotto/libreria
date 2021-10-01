package com.libreria.libreria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libreria.libreria.errores.ErrorServicio;
import com.libreria.libreria.servicios.AutorServicio;

@Controller
@RequestMapping("/")
public class PortalControlador {
	
	
	@Autowired
	private AutorServicio autorServicio;

	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/cargarLibro")
	public String cargarLibro() {
		return "cargarLibro.html";
	}
	
	@PostMapping("/cargarLibro")
	public String registrarLibro(@RequestParam String nombre) {
		
		
		try {
			autorServicio.registrarAutor(nombre);
		} catch (ErrorServicio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cargarLibro.html";
	}
}	
