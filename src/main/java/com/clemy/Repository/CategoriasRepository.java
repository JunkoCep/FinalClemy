package com.clemy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clemy.modelo.Categorias;




@Repository
public interface CategoriasRepository extends JpaRepository <Categorias, Integer> {

}
