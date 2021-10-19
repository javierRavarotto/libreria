package com.libreria.libreria.servicios;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.libreria.entidades.Autor;

import com.libreria.libreria.errores.ErrorServicio;
import com.libreria.libreria.repositorios.AutorRepositorio;

@Service
public class AutorServicio {
	
	@Autowired
	private AutorRepositorio autorRepositorio;
	
	@Transactional
	public void registrarAutor(String nombre )throws ErrorServicio {
		
		if(nombre==null || nombre.isEmpty()) {
			throw new ErrorServicio("nombre no puede ser nulo");
		}
		
		Autor autor =new Autor();
		
		autor.setNombre(nombre);
		autor.setAlta(true);
		
		autorRepositorio.save(autor);
	}
	
	@Transactional
	public void editarAutor(String id, String nombre )throws ErrorServicio {
	
	
		Autor autor = autorRepositorio.findById(id).get();
	
		
		autor.setNombre(nombre);
			
		
		autorRepositorio.save(autor);	
	}
	
	public Autor buscarPorId(String id) {
		
		Autor autor = autorRepositorio.findById(id).get();
		
		return autor;
	}
	
	
	@Transactional
	public void altaBaja(String id)throws ErrorServicio {
	
	
		Autor autor = autorRepositorio.findById(id).get();

		if(autor.getAlta()==true) {
			autor.setAlta(false);
		}else {
			autor.setAlta(true);
		}
	
			
		
		autorRepositorio.save(autor);	
	}

	
	
}
