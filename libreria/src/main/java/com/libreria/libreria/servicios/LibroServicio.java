package com.libreria.libreria.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.libreria.entidades.Autor;
import com.libreria.libreria.entidades.Editorial;
import com.libreria.libreria.entidades.Libro;
import com.libreria.libreria.errores.ErrorServicio;
import com.libreria.libreria.repositorios.LibroRepositorio;

@Service
public class LibroServicio {

	
	@Autowired
	private LibroRepositorio libroRepositorio;
	
	@Transactional
	public void registrarLibro(Long isbn,String titulo,Integer anio,Integer ejemplares,Integer ejemplaresPrestados,
			Integer EjemplaresRestantes, Autor autor,Editorial editorial)throws ErrorServicio {
		
	
		
		Libro libro =new Libro();
		
		libro.setIsbn(isbn);
		libro.setTitulo(titulo);
		libro.setAnio(anio);
		libro.setEjemplares(ejemplares);
		libro.setEjemplaresPrestados(ejemplaresPrestados);
		libro.setEjemplaresRestantes(EjemplaresRestantes);
		libro.setAlta(true);
		libro.setAutor(autor);
		libro.setEditorial(editorial);
		
		libroRepositorio.save(libro);
	}
	
	@Transactional
	public void editarLibro(String id,Long isbn,String titulo,Integer anio,Integer ejemplares,Integer ejemplaresPrestados,
			Integer EjemplaresRestantes, Autor autor,Editorial editorial )throws ErrorServicio {
	
	
		Libro libro = libroRepositorio.findById(id).get();
	
		
		libro.setIsbn(isbn);
		libro.setTitulo(titulo);
		libro.setAnio(anio);
		libro.setEjemplares(ejemplares);
		libro.setEjemplaresPrestados(ejemplaresPrestados);
		libro.setEjemplaresRestantes(EjemplaresRestantes);
		libro.setAutor(autor);
		libro.setEditorial(editorial);
			
		
		libroRepositorio.save(libro);	
	}
	
	public Libro buscarPorId(String id) {
		
		Libro libro = libroRepositorio.findById(id).get();
		
		return libro;
	}
	
	@Transactional
	public void altaBaja(String id)throws ErrorServicio {
	
	
		Libro libro = libroRepositorio.findById(id).get();

		if(libro.getAlta()==true) {
			libro.setAlta(false);
		}else {
			libro.setAlta(true);
		}
	
			
		
		libroRepositorio.save(libro);	
	}


	
	public Boolean  mostrarAlta(Boolean altas)throws ErrorServicio {

		if(altas==false) {
			altas=true;
		}
		return altas;
	}
	public Boolean  mostrarBaja(Boolean altas)throws ErrorServicio {

		if(altas==true) {
			altas=false;
		}
		return altas;
	}
}
