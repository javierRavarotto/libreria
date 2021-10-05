package com.libreria.libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LibroControlador {
	
	@GetMapping("/cargarLibro")
	public String cargarLibro() {
		return "cargarLibro.html";
	}
	
	

}
