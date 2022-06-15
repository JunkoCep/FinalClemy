package com.clemy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clemy.modelo.UnidadesMedida;


@Repository
public interface UnidadMedidaRepository  extends JpaRepository<UnidadesMedida, Integer>{

}
