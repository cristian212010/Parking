package com.Services;

import java.util.List;

import com.TO.Plazas;

public interface IPlazasService {
    public List<Plazas> listarPlazas();

    public void eliminar(Plazas plaza);

    public void eliminarPlaza(int idPlaza);

    public Plazas guardar(Plazas plaza);

    public Plazas buscarPlaza(int idPlaza);

}
