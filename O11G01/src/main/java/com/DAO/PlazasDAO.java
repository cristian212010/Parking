package com.DAO;

import com.TO.Plazas;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlazasDAO extends CrudRepository<Plazas, Integer>{

    @Query(value="Select * FROM plazas WHERE estado='libre' AND tipo= ?1", nativeQuery=true)
    List<Plazas> plazasLibresxTipo (String tipo);

    @Query(value="Select * FROM plazas WHERE estado='libre'", nativeQuery=true)
    List<Plazas> plazasLibres();
    
}
