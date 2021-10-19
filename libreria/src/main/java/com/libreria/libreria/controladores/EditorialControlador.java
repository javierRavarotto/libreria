package com.libreria.libreria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libreria.libreria.entidades.Editorial;
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
	
	
	@GetMapping("/editarEditorial/{id}")
	public String editarEditorial(@PathVariable String id, ModelMap model) {
		Editorial editorial = editorialServicio.buscarPorId(id);
		model.addAttribute("editorial",editorial);
		
		return "editarEditorial.html";
	}
	
	@GetMapping("/altaBajaEditorial/{id}")
	public String altaBajaEditorial(@PathVariable String id, ModelMap model) throws ErrorServicio   {
		
		Editorial editorial = editorialServicio.buscarPorId(id);
		model.addAttribute("editorial",editorial);
		editorialServicio.altaBaja(id);
		return "redirect:/";
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
	
	@PostMapping("/editarEditorial")
	public String editarEditorial(@RequestParam String id,@RequestParam String nombre) throws ErrorServicio {
		
		editorialServicio.editarEditorial(id, nombre);
		return "redirect:/";
	}
	
}
