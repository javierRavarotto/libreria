package com.libreria.libreria.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libreria.libreria.entidades.Autor;
import com.libreria.libreria.entidades.Editorial;
import com.libreria.libreria.entidades.Libro;
import com.libreria.libreria.errores.ErrorServicio;
import com.libreria.libreria.repositorios.AutorRepositorio;
import com.libreria.libreria.repositorios.EditorialRepositorio;
import com.libreria.libreria.servicios.LibroServicio;


@Controller
@RequestMapping("/")
public class LibroControlador {

	@Autowired
	private LibroServicio libroServicio;
	 
	
	@Autowired
	private AutorRepositorio autorRepositorio;

	@Autowired
	private EditorialRepositorio editorialRepositorio;
	
	
	@GetMapping("/cargarLibro")
	public String cargarLibro(ModelMap modelo) {
List<Autor> listaAutor = autorRepositorio.findAll();
List<Editorial> listaEditoriales = editorialRepositorio.findAll();
		
		modelo.put("autores", listaAutor);
		modelo.put("editoriales", listaEditoriales);
		return "cargarLibro.html";
	}
	

	
	
	
	@GetMapping("/editarLibro/{id}")
	public String editarLibro(@PathVariable String id, ModelMap model,ModelMap modelo) {
		List<Autor> listaAutor = autorRepositorio.findAll();
		List<Editorial> listaEditoriales = editorialRepositorio.findAll();
		Libro libro = libroServicio.buscarPorId(id);
		modelo.put("autores", listaAutor);
		modelo.put("editoriales", listaEditoriales);
		
		model.addAttribute("libro",libro);
		return "editarLibro.html";
	}
	
	
	/*dar de baja o alta un libro*/
	@GetMapping("/altaBajaLibro/{id}")
	public String altaBaja(@PathVariable String id, ModelMap model) throws ErrorServicio   {
		
		Libro libro = libroServicio.buscarPorId(id);
		model.addAttribute("libro",libro);
		libroServicio.altaBaja(id);
		return "redirect:/";
	}
	
	
	
	@PostMapping("/cargarLibro")
	public String registrarLibro(@RequestParam Long isbn,@RequestParam String titulo,@RequestParam Integer anio,@RequestParam Integer ejemplares,@RequestParam Integer ejemplaresPrestados,
			@RequestParam Integer ejemplaresRestantes,@RequestParam Autor IdAutor,@RequestParam Editorial IdEditorial) {
		
		try {

			libroServicio.registrarLibro(isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes,IdAutor,IdEditorial);
		} catch (ErrorServicio e) {
			
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	
	@PostMapping("/editarLibro")
	public String editarAutor(@RequestParam String id,@RequestParam Long isbn,@RequestParam String titulo,@RequestParam Integer anio,@RequestParam Integer ejemplares,@RequestParam Integer ejemplaresPrestados,
			@RequestParam Integer ejemplaresRestantes,@RequestParam Autor IdAutor,@RequestParam Editorial IdEditorial) throws ErrorServicio {
		
		libroServicio.editarLibro( id,isbn, titulo, anio, ejemplares, ejemplaresPrestados,ejemplaresRestantes,  IdAutor, IdEditorial);
		return "redirect:/";
	}
}
