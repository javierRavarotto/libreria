package com.libreria.libreria.controladores;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libreria.libreria.entidades.Autor;
import com.libreria.libreria.entidades.Editorial;
import com.libreria.libreria.entidades.Libro;
import com.libreria.libreria.errores.ErrorServicio;
import com.libreria.libreria.repositorios.AutorRepositorio;
import com.libreria.libreria.repositorios.EditorialRepositorio;
import com.libreria.libreria.repositorios.LibroRepositorio;
import com.libreria.libreria.servicios.LibroServicio;





@Controller
@RequestMapping("/")
public class PortalControlador {
	
	@Autowired
	private LibroRepositorio libroRepositorio;
	@Autowired
	private AutorRepositorio autorRepositorio;
	
	@Autowired
	private LibroServicio libroServicio;

	@Autowired
	private EditorialRepositorio editorialRepositorio;
	
	Boolean	altas=true;
	@GetMapping("/")
	public String index(ModelMap modelo) throws ErrorServicio {
	
		List<Autor> listaAutor = autorRepositorio.findAll();
		List<Editorial> listaEditoriales = editorialRepositorio.findAll();
		List<Libro> listaLibros = libroRepositorio.findAll();
				
				
		 modelo.put("altas",altas);
				modelo.put("autores", listaAutor);
				modelo.put("libros", listaLibros);
				modelo.put("editoriales", listaEditoriales);
				
		return "index.html";
	}
	
	

	
	@GetMapping("/mostrarAlta/")
	public String mostrarAlta(ModelMap modelo) throws ErrorServicio {

		altas=libroServicio.mostrarAlta(this.altas);
		 System.out.println(altas);
		return "redirect:/";
	}
	
	@GetMapping("/mostrarBaja/")
	public String mostrarBaja(ModelMap modelo) throws ErrorServicio {

		altas=libroServicio.mostrarBaja(this.altas);
		 System.out.println(altas);
		return "redirect:/";
	}

}	
