package com.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.PlazasDAO;
import com.TO.Plazas;

@Service
public class PlazasService implements IPlazasService {

    @Autowired
    private PlazasDAO plazasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Plazas> listarPlazas() {
        return (List<Plazas>) plazasDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Plazas> plazasLibres() {
        return (List<Plazas>) plazasDao.plazasLibres();
    }

    @Transactional(readOnly = true)
    public List<Plazas> plazasLibresxTipo(String tipo) {
        return (List<Plazas>) plazasDao.plazasLibresxTipo(tipo);
    }

    @Override
    @Transactional
    public void eliminar(Plazas plaza) {
        plazasDao.delete(plaza);

    }

    @Override
    @Transactional
    public Plazas guardar(Plazas plaza) {
        return plazasDao.save(plaza);
    }

    @Override
    @Transactional(readOnly = true)
    public Plazas buscarPlaza(int idPlaza) {
        return plazasDao.findById(idPlaza).orElse(null);
    }

    @Override
    public void eliminarPlaza(int idPlaza) {
        plazasDao.deleteById(idPlaza);
        
    }
    
}
