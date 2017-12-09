/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceamce.salika.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Cesar Aguirre Vega
 */
@Entity
@Table(name = "usuario")
public class UsuarioVO implements Serializable{
    
    @Id
    @GeneratedValue
    private int usua_id;
    @NotEmpty    
    private String usua_usuario;
    @NotEmpty    
    private String usua_password;
    private String usua_estado;
    private Timestamp usua_fecharegistro;
    @NotEmpty
    private String usua_permiso;
    
    @Transient
    private TareaVO tareaEjecionVO;
    
    @OneToMany(mappedBy = "usuario")
    private List<TareaVO> tareas; 

    public int getUsua_id() {
        return usua_id;
    }

    public void setUsua_id(int usua_id) {
        this.usua_id = usua_id;
    }

    public String getUsua_usuario() {
        return usua_usuario;
    }

    public void setUsua_usuario(String usua_usuario) {
        this.usua_usuario = usua_usuario;
    }

    public String getUsua_password() {
        return usua_password;
    }

    public void setUsua_password(String usua_password) {
        this.usua_password = usua_password;
    }

    public String getUsua_estado() {
        return usua_estado;
    }

    public void setUsua_estado(String usua_estado) {
        this.usua_estado = usua_estado;
    }

    public Timestamp getUsua_fecharegistro() {
        return usua_fecharegistro;
    }

    public void setUsua_fecharegistro(Timestamp usua_fecharegistro) {
        this.usua_fecharegistro = usua_fecharegistro;
    }

    public List<TareaVO> getTareas() {
        return tareas;
    }

    public void setTareas(List<TareaVO> tareas) {
        this.tareas = tareas;
    }

    public TareaVO getTareaEjecionVO() {
        return tareaEjecionVO;
    }

    public void setTareaEjecionVO(TareaVO tareaEjecionVO) {
        this.tareaEjecionVO = tareaEjecionVO;
    }

    public String getUsua_permiso() {
        return usua_permiso;
    }

    public void setUsua_permiso(String usua_permiso) {
        this.usua_permiso = usua_permiso;
    }

//    @Override
//    public String toString() {
//        return "UsuarioVO{" + "usua_id=" + usua_id + ", usua_usuario=" + usua_usuario + ", usua_password=" + usua_password + ", usua_estado=" + usua_estado + ", usua_fecharegistro=" + usua_fecharegistro + ", usua_permiso=" + usua_permiso + ", tareaEjecionVO=" + tareaEjecionVO + ", tareas=" + tareas + '}';
//    }
    
    
    

}
