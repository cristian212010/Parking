package com.TO;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
@Table(name="configuraciones")
public class Configuracion implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idConfiguraciones;
    @Column(name="nombreparqueadero")
    private String nombreParqueadero;
    @Column(name="valorhoracarro")
    private String valorHoraCarro;
    @Column(name="valorhoramoto")
    private String valorHoraMoto;
    @Column(name="valorfraccarro")
    private String valorFracCarro;
    @Column(name="valorfracmoto")
    private String valorFracMoto;
    @Column(name="valordiacarro")
    private String valorDiaCarro;
    @Column(name="valordiamoto")
    private String valorDiaMoto;
    @Column(name="valorsemcarro")
    private String valorSemCarro;
    @Column(name="valorsemmoto")
    private String valorSemMoto;
    @Column(name="valormescarro")
    private String valorMesCarro;
    @Column(name="valormesmoto")
    private String valorMesMoto;
    
}