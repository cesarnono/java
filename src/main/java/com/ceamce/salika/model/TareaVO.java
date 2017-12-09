/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceamce.salika.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Timeout;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import jdk.nashorn.internal.runtime.regexp.joni.Syntax;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Cesar Aguirre Vega
 */
@Entity
@Table(name = "tarea")
public class TareaVO implements Serializable {

    @Id
    @GeneratedValue
    private int tare_id;
    private String tare_codigo;
    private String tare_descripcion;
    private String tare_estado;
    private Long tare_tiempoacumulado;
    @ManyToOne
    @JoinColumn(name = "usua_id")
    private UsuarioVO usuario;
    private Timestamp tare_fecharegistro;    
    private Timestamp tare_fechainicio;
    private Timestamp tare_fechareinicio;
    private Timestamp tare_fechafin;
    private long tare_dias;
    private long tare_horas;
    private long tare_minutos;
    private long tare_segundos;
    private long tare_centesimas;
    @OneToMany(mappedBy = "tareaVO")    
    private List<NotaVO> notas;
    @Transient
    private String dias;
    @Transient
    private String horas;
    @Transient
    private String minutos;
    @Transient
    private String segundos;

    public int getTare_id() {
        return tare_id;
    }

    public void setTare_id(int tare_id) {
        this.tare_id = tare_id;
    }

    public String getTare_codigo() {
        return tare_codigo;
    }

    public void setTare_codigo(String tare_codigo) {
        this.tare_codigo = tare_codigo;
    }

    public String getTare_descripcion() {
        return tare_descripcion;
    }

    public void setTare_descripcion(String tare_descripcion) {
        this.tare_descripcion = tare_descripcion;
    }

    public String getTare_estado() {
        return tare_estado;
    }

    public void setTare_estado(String tare_estado) {
        this.tare_estado = tare_estado;
    }

    public Long getTare_tiempoacumulado() {
        return tare_tiempoacumulado;
    }

    public void setTare_tiempoacumulado(Long tare_tiempoacumulado) {
        this.tare_tiempoacumulado = tare_tiempoacumulado;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public Timestamp getTare_fecharegistro() {
        return tare_fecharegistro;
    }

    public void setTare_fecharegistro(Timestamp tare_fecharegistro) {
        this.tare_fecharegistro = tare_fecharegistro;
    }

    public Timestamp getTare_fechainicio() {
        return tare_fechainicio;
    }

    public void setTare_fechainicio(Timestamp tare_fechainicio) {
        this.tare_fechainicio = tare_fechainicio;
    }
    
    public void setTare_fechainicio(String tare_fechainicio){       
        
    }

    public Timestamp getTare_fechareinicio() {
        return tare_fechareinicio;
    }

    public void setTare_fechareinicio(Timestamp tare_fechareinicio) {
        this.tare_fechareinicio = tare_fechareinicio;
    }

    public Timestamp getTare_fechafin() {
        return tare_fechafin;
    }

    public void setTare_fechafin(Timestamp tare_fechafin) {
        this.tare_fechafin = tare_fechafin;
    }

    @Override
    public String toString() {
        return "TareaVO{" + "tare_id=" + tare_id + ", tare_codigo=" + tare_codigo + ", tare_estado=" + tare_estado + ", tare_tiempoacumulado=" + tare_tiempoacumulado + ", tare_fecharegistro=" + tare_fecharegistro + ", tare_fechainicio=" + tare_fechainicio + ", tare_fechareinicio=" + tare_fechareinicio + ", tare_fechafin=" + tare_fechafin + '}';
    }

    

    public long getTare_dias() {
        return tare_dias;
    }

    public void setTare_dias(long tare_dias) {
        this.tare_dias = tare_dias;
    }

    public long getTare_horas() {
        return tare_horas;
    }

    public void setTare_horas(long tare_horas) {
        this.tare_horas = tare_horas;
    }

    public long getTare_minutos() {
        return tare_minutos;
    }

    public void setTare_minutos(long tare_minutos) {
        this.tare_minutos = tare_minutos;
    }

    public long getTare_segundos() {
        return tare_segundos;
    }

    public void setTare_segundos(long tare_segundos) {
        this.tare_segundos = tare_segundos;
    }

    public long getTare_centesimas() {
        return tare_centesimas;
    }

    public void setTare_centesimas(long tare_centesimas) {
        this.tare_centesimas = tare_centesimas;
    }

    public String getHoras() {
       horas = tare_horas <10 ? ("0"+tare_horas):String.valueOf(tare_horas);
        return horas;
    }

    public String getMinutos() {
         minutos = tare_minutos <10 ? ("0"+tare_minutos):String.valueOf(tare_minutos);
        return minutos;
    }

    public String getSegundos() {
         segundos = tare_segundos <10 ? ("0"+tare_segundos):String.valueOf(tare_segundos);
        return segundos;
    }

    public String getDias() {
        dias = tare_dias <10 ? ("0"+tare_dias):String.valueOf(tare_dias);
        return dias;
    }

    public List<NotaVO> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaVO> notas) {
        this.notas = notas;
    }
    
    

}
