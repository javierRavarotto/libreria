package com.libreria.libreria.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libreria.libreria.entidades.Editorial;




@Controller
@RequestMapping("/")
public class PortalControlador {
	

	@GetMapping("/")
	public String index(Editorial model) {
		model.getNombre();
		
		return "index.html";
	}


}	
