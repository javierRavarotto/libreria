package com.libreria.libreria.controladores;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libreria.libreria.entidades.Autor;
import com.libreria.libreria.entidades.Editorial;
import com.libreria.libreria.entidades.Libro;
import com.libreria.libreria.repositorios.AutorRepositorio;
import com.libreria.libreria.repositorios.EditorialRepositorio;
import com.libreria.libreria.repositorios.LibroRepositorio;




@Controller
@RequestMapping("/")
public class PortalControlador {
	
	@Autowired
	private LibroRepositorio libroRepositorio;
	@Autowired
	private AutorRepositorio autorRepositorio;

	@Autowired
	private EditorialRepositorio editorialRepositorio;
	

	@GetMapping("/")
	public String index(ModelMap modelo) {
	
		List<Autor> listaAutor = autorRepositorio.findAll();
		List<Editorial> listaEditoriales = editorialRepositorio.findAll();
		List<Libro> listaLibros = libroRepositorio.findAll();
				
				modelo.put("autores", listaAutor);
				modelo.put("libros", listaLibros);
				modelo.put("editoriales", listaEditoriales);
		return "index.html";
	}


}	
