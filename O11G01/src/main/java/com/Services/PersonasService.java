package com.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.PersonasDAO;
import com.TO.Personas;

@Service
public class PersonasService implements IPersonasService {

    @Autowired
    private PersonasDAO personasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Personas> listarPersonas() {
        return (List<Personas>) personasDao.findAll();
    }

    @Override
    @Transactional
    public void eliminar(Personas persona) {
        personasDao.delete(persona);

    }

    @Override
    @Transactional
    public Personas guardar(Personas persona) {
        return personasDao.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Personas buscarPersona(int idPersona) {
        return personasDao.findById(idPersona).orElse(null);
    }

    @Override
    public void eliminarPersona(int idPersona) {
        personasDao.deleteById(idPersona);
        
    }
    
}
