package com.clemy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clemy.modelo.Provedores;



@Repository
public interface ProvedorRepository extends JpaRepository<Provedores, Integer>{

}
