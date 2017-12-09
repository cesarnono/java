/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceamce.salika.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author César Aguirre Vega
 */
@Entity
@Table(name = "nota")
public class NotaVO implements Serializable{
    
    @Id
    @GeneratedValue
    private int nota_id;
    private String nota_nombre;
    private String nota_descripcion;
    @ManyToOne
    @JoinColumn(name = "tare_id")
    private TareaVO tareaVO;
    
    @ManyToOne
    @JoinColumn(name = "tino_id")
    private TipoNotaVO tipoNotaVO;
    private Timestamp nota_fecharegistro;

    public int getNota_id() {
        return nota_id;
    }

    public void setNota_id(int nota_id) {
        this.nota_id = nota_id;
    }

    public String getNota_nombre() {
        return nota_nombre;
    }

    public void setNota_nombre(String nota_nombre) {
        this.nota_nombre = nota_nombre;
    }

    public String getNota_descripcion() {
        return nota_descripcion;
    }

    public void setNota_descripcion(String nota_descripcion) {
        this.nota_descripcion = nota_descripcion;
    }

    public TareaVO getTareaVO() {
        return tareaVO;
    }

    public void setTareaVO(TareaVO tareaVO) {
        this.tareaVO = tareaVO;
    }

    public TipoNotaVO getTipoNotaVO() {
        return tipoNotaVO;
    }

    public void setTipoNotaVO(TipoNotaVO tipoNotaVO) {
        this.tipoNotaVO = tipoNotaVO;
    }

    public Timestamp getNota_fecharegistro() {
        return nota_fecharegistro;
    }

    public void setNota_fecharegistro(Timestamp nota_fecharegistro) {
        this.nota_fecharegistro = nota_fecharegistro;
    }

//    @Override
//    public String toString() {
//        return "NotaVO{" + "nota_id=" + nota_id + ", nota_nombre=" + nota_nombre + ", nota_descripcion=" + nota_descripcion + ", tareaVO=" + tareaVO + ", tipoNotaVO=" + tipoNotaVO + ", nota_fecharegistro=" + nota_fecharegistro + '}';
//    }

}
