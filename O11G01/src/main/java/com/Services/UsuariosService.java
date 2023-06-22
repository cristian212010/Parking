package com.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.UsuariosDAO;
import com.TO.Usuarios;

@Service
public class UsuariosService implements IUsuariosService {

    @Autowired
    private UsuariosDAO usuariosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> listarUsuarios() {
        return (List<Usuarios>) usuariosDao.findAll();
    }

    @Override
    @Transactional
    public void eliminar(Usuarios usuario) {
        usuariosDao.delete(usuario);

    }

    @Override
    @Transactional
    public Usuarios guardar(Usuarios usuario) {
        return usuariosDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios buscarUsuario(int idUsuario) {
        return usuariosDao.findById(idUsuario).orElse(null);
    }

    @Override
    public void eliminarUsuario(int idUsuario) {
        usuariosDao.deleteById(idUsuario);
        
    }
    
}
