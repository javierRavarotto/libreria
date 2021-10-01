package com.libreria.libreria.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.libreria.entidades.Editorial;
import com.libreria.libreria.errores.ErrorServicio;
import com.libreria.libreria.repositorios.EditorialRepositorio;

@Service
public class EditorialServicio {
	@Autowired
	private EditorialRepositorio editorialRepositorio;
	
	@Transactional
	public void registrarEditorial(String nombre )throws ErrorServicio {
		
		if(nombre==null || nombre.isEmpty()) {
			throw new ErrorServicio("nombre no puede ser nulo");
		}
		
		Editorial editorial =new Editorial();
		
		editorial.setNombre(nombre);
		editorial.setAlta(true);
		
		editorialRepositorio.save(editorial);
	}

}
