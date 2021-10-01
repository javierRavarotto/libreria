package com.libreria.libreria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libreria.libreria.entidades.Autor;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor,String> {

}
