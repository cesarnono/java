/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceamce.salika.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author César Aguirre Vega
 */
@Entity
@Table(name = "tipoNota")
public class TipoNotaVO implements Serializable {

    @Id
    @GeneratedValue
    private int tino_id;
    private String tino_nombre;
    private String tino_editable;

    public int getTino_id() {
        return tino_id;
    }

    public void setTino_id(int tino_id) {
        this.tino_id = tino_id;
    }

    public String getTino_nombre() {
        return tino_nombre;
    }

    public void setTino_nombre(String tino_nombre) {
        this.tino_nombre = tino_nombre;
    }

    public String getTino_editable() {
        return tino_editable;
    }

    public void setTino_editable(String tino_editable) {
        this.tino_editable = tino_editable;
    }

//    @Override
//    public String toString() {
//        return "TipoNotaVO{" + "tino_id=" + tino_id + ", tino_nombre=" + tino_nombre + ", tino_editable=" + tino_editable + '}';
//    }
}
