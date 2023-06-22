package com.Services;

import java.util.List;

import com.TO.Facturas;

public interface IFacturasService {
    public List<Facturas> listarFacturas();

    public void eliminar(Facturas factura);

    public void eliminarFactura(int idFactura);

    public Facturas guardar(Facturas factura);

    public Facturas buscarFactura(int idFactura);


}
