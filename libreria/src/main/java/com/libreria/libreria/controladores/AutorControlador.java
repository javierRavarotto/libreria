package com.libreria.libreria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import com.libreria.libreria.entidades.Autor;
import com.libreria.libreria.errores.ErrorServicio;
import com.libreria.libreria.servicios.AutorServicio;



@Controller
@RequestMapping("/")
public class AutorControlador {
	@Autowired
	private AutorServicio autorServicio;
	
	@GetMapping("/cargarAutor")
	public String cargarLibro() {
		return "cargarAutor.html";
	}
	
	@PostMapping("/cargarAutor")
	public String registrarLibro(@RequestParam String nombre) {
		
		
		try {
			autorServicio.registrarAutor(nombre);
		} catch (ErrorServicio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cargarAutor.html";
	}
/*	
	@GetMapping("/cargarAutor")
	public String mostrarAutor(Model  model) {
		
		List<Autor> listaAutor = autorServicio.mostrarAutor();
		return "cargarAutor.html";
	}
	*/
	
}
