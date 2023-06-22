package com.Services;

import java.util.List;

import com.TO.Usuarios;

public interface IUsuariosService {
    public  List<Usuarios> listarUsuarios();

    public void eliminar(Usuarios idUsuarios);

    public Usuarios guardar(Usuarios usuario);

    public void eliminarUsuario(int idUsuarios);

    public Usuarios buscarUsuario(int idUsuarios);
}
