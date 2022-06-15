package com.clemy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clemy.modelo.Inventario;


 @Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

}
