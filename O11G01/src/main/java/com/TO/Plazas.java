package com.TO;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
@Table(name="plazas")
public class Plazas implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idPlazas;
    @Column(name="codigoplaza")
    private String codigoPlaza;
    private String tipo;
    private String estado;

    
}