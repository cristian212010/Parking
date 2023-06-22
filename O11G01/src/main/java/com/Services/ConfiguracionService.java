package com.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.ConfiguracionDAO;
import com.TO.Configuracion;

@Service
public class ConfiguracionService implements IConfiguracionService {

    @Autowired
    private ConfiguracionDAO configuracionDao;

    @Override
    @Transactional
    public Configuracion guardar(Configuracion configuracion) {
        return configuracionDao.save(configuracion);
    }

    @Override
    @Transactional(readOnly = true)
    public Configuracion buscarConfiguracion(int idConfiguracion) {
        return configuracionDao.findById(idConfiguracion).orElse(null);
    }

    
}
