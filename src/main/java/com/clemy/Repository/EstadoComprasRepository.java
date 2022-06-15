package com.clemy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clemy.modelo.estadocompras;



@Repository
public interface EstadoComprasRepository extends JpaRepository<estadocompras, Integer> {

}
