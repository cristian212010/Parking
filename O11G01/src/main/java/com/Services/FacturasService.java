package com.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.FacturasDAO;
import com.TO.Facturas;

@Service
public class FacturasService implements IFacturasService {

    @Autowired
    private FacturasDAO facturasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Facturas> listarFacturas() {
        return (List<Facturas>) facturasDao.findAll();
    }

    @Override
    @Transactional
    public void eliminar(Facturas factura) {
        facturasDao.delete(factura);

    }

    @Override
    @Transactional
    public Facturas guardar(Facturas factura) {
        return facturasDao.save(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public Facturas buscarFactura(int idFactura) {
        return facturasDao.findById(idFactura).orElse(null);
    }

    @Override
    public void eliminarFactura(int idFactura) {
        facturasDao.deleteById(idFactura);
        
    }

    
}
