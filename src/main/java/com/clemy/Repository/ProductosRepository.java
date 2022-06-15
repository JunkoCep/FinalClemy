package com.clemy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clemy.modelo.Productos;



@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

}
