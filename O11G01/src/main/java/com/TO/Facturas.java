package com.TO;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Data
@Entity
@Table(name="factura")
public class Facturas implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idFactura;
    @Column(name="codigofactura")
    private int codigoFactura;
    private String placa;
    @Column(name="tipocontrato")
    private String tipoContrato;
    @Column(name="fechaentrada")
    private Date fechaEntrada;
    @Column(name="fechasalida")
    private Date fechaSalida;
    private String valor;
    @Column(name="fechafactura")
    private Date fechaFactura;
    private int idPersonas;
    private int idPlazas;
    
    
}