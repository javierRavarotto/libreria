package com.libreria.libreria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libreria.libreria.errores.ErrorServicio;
import com.libreria.libreria.servicios.AutorServicio;
import com.libreria.libreria.servicios.EditorialServicio;

@Controller
@RequestMapping("/")
public class PortalControlador {
	
	
	@Autowired
	private AutorServicio autorServicio;
	
	@Autowired
	private EditorialServicio editorialServicio;

	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	/*---------------------------------------------------------------------*/
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
	
	
	/*---------------------------------------------------------*/
	@GetMapping("/cargarEditorial")
	public String cargarEditorial() {
		return "cargarEditorial.html";
	}
	
	@PostMapping("/cargarEditorial")
	public String registrarEditorial(@RequestParam String nombre) {
		
		
		try {
			editorialServicio.registrarEditorial(nombre);
		} catch (ErrorServicio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cargarEditorial.html";
	}
}	
