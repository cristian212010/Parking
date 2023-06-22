package com.Services;

import java.util.List;

import com.TO.Usuarios;

public interface IUsuariosService {
    public List<Usuarios> listarUsuarios();

    public void eliminar(Usuarios usuario);

    public void eliminarUsuario(int idUsuario);

    public Usuarios guardar(Usuarios usuario);

    public Usuarios buscarUsuario(int idUsuario);
}
