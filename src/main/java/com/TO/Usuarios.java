package com.TO;
import lombok.Data;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data //incluye los getter y los setter
@Entity //reconoce como un objeto de ellos
@Table( name ="usuarios") //Especifica el nombre de la tabla de sql
//clases que implementan o heredan de como los va a identifcar  Serializable
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idUsuarios;
    private String usuario;
    private String clave;
    private String rol;
    private int idPersonas;

}
