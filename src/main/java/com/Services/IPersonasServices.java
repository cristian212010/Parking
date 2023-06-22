package com.Services;

import java.util.List;

import com.TO.Personas;

public interface IPersonasServices{
    public  List<Personas> listarPersonas();

    public void eliminar(Personas idPersona);

    public Personas guardar(Personas persona);

    public void eliminarPersona(int idPersona);

    public Personas buscarPersona(int idPersona);
}
