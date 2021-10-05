package com.libreria.libreria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libreria.libreria.errores.ErrorServicio;
import com.libreria.libreria.servicios.EditorialServicio;

@Controller
@RequestMapping("/")
public class EditorialControlador {
	
	@Autowired
	private EditorialServicio editorialServicio;
	
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
