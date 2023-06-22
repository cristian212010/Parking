package com.TO;
import lombok.Data;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data //incluye los getter y los setter
@Entity //reconoce como un objeto de ellos
@Table( name ="personas") //Especifica el nombre de la tabla de sql
//clases que implementan o heredan de como los va a identifcar  Serializable
public class Personas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idPersonas;
    private String nombres;
    private String apellidos;
    @Column(name="tipodoc")
    private String tipoDoc;
    @Column(name="numdoc")
    private int numDoc;
    private String direccion;
    private String telefono;
    private String email;

}
