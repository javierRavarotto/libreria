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
public class AutorControlador {
	@Autowired
	private AutorServicio autorServicio;
	
	
	/*GET*/
	@GetMapping("/cargarAutor")
	public String cargarAutor() {
		return "cargarAutor.html";
	}
	
	
	
	/*POST*/
	
	@PostMapping("/cargarAutor")
	public String registrarAutor(@RequestParam String nombre) {
		
		
		try {
			autorServicio.registrarAutor(nombre);
		} catch (ErrorServicio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cargarAutor.html";
	}
	

	@PostMapping("/editarAutor")
	public String editarAutor(@RequestParam String id,@RequestParam String nombre,@RequestParam Boolean alta ) {
		return "editarAutor.html";
	}

	
}
