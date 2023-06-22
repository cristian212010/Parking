package com.DAO;

import com.TO.Facturas;

import org.springframework.data.repository.CrudRepository;

public interface FacturasDAO extends CrudRepository<Facturas, Integer>{
    
}
