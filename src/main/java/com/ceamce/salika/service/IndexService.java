/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceamce.salika.service;

import com.ceamce.salika.dao.NotaDAOImp;
import com.ceamce.salika.dao.TareaDAOImp;
import com.ceamce.salika.dao.TipoNotaDAOImp;
import com.ceamce.salika.dao.UsuarioDAOImp;
import com.ceamce.salika.model.NotaVO;
import com.ceamce.salika.model.TareaVO;
import com.ceamce.salika.model.UsuarioVO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author César Aguirre Vega
 */
@Service
@Transactional
public class IndexService {

    @Autowired
    private UsuarioDAOImp usuarioDAOImp;

    @Autowired
    private TareaDAOImp tareaDAOImp;

    @Autowired
    private NotaDAOImp notaDAOImp;

    @Autowired
    private TipoNotaDAOImp tipoNotaDAOImp;

    private static final long SEGUNDOS_POR_DIA = 86440;
    private static final long SEGUNDOS_POR_HORA = 3600;
    private static final long SEGUNDOS_POR_MINUTO = 60;

    public UsuarioVO consultarUsuario(int id) {
        UsuarioVO usuarioVO = usuarioDAOImp.consultar(id);
        if (usuarioVO == null) {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
        return usuarioVO;
    }

    public UsuarioVO consultarUsuario(String nombreUsuario) {
        UsuarioVO usuarioVO = usuarioDAOImp.findByUsername(nombreUsuario);
        if (usuarioVO == null) {
            throw new RuntimeException("Usuario no encontrado con nombreusuario: " + nombreUsuario);
        }
        return usuarioVO;
    }

    public void registrarTarea(TareaVO tareaVO) {
        tareaVO.setTare_fecharegistro(new Timestamp(new Date().getTime()));
        tareaVO.setTare_tiempoacumulado(0L);
        tareaVO.setTare_estado("PENDIENTE");
        tareaDAOImp.registrar(tareaVO);
    }

    public void pausarEjecucionTarea(HttpServletRequest request, int idtarea) {
        TareaVO tarea = this.tareaDAOImp.consultar(idtarea);
        if (tarea != null) {
            NotaVO notaVO = new NotaVO();
            notaVO.setTipoNotaVO(this.tipoNotaDAOImp.consultar(2));
            notaVO.setNota_nombre("PAUSA");
            notaVO.setNota_descripcion("Pausa de tarea");
            String dias = request.getParameter("dias_" + idtarea);
            String horas = request.getParameter("horas_" + idtarea);
            String minutos = request.getParameter("minutos_" + idtarea);
            String segundos = request.getParameter("segundos_" + idtarea);
            String centesimas = request.getParameter("centesimas_" + idtarea);
            tarea.setTare_dias(Integer.parseInt(dias));
            tarea.setTare_horas(Integer.parseInt(horas));
            tarea.setTare_minutos(Integer.parseInt(minutos));
            tarea.setTare_segundos(Integer.parseInt(segundos));
            tarea.setTare_centesimas(Integer.parseInt(centesimas));
            tarea.setTare_estado("PENDIENTE");
            notaVO.setTareaVO(tarea);
            notaVO.setNota_fecharegistro(new Timestamp(new Date().getTime()));
            this.notaDAOImp.registrar(notaVO);
        } else {
            throw new RuntimeException("No se pudo encontrar la tarea");
        }
    }

    public void iniciarTarea(int idtarea) {
        System.out.println("iniciar tarea en el service");
        TareaVO tarea = this.tareaDAOImp.consultar(idtarea);
        System.out.println("tarea = " + tarea);
        if (tarea != null) {
            NotaVO notaVO = new NotaVO();
            notaVO.setTipoNotaVO(this.tipoNotaDAOImp.consultar(tarea.getTare_fechainicio() == null ? 1 : 2));
            if (tarea.getTare_fechainicio() == null) {
                tarea.setTare_fechainicio(new Timestamp(new Date().getTime()));
                notaVO.setNota_nombre("INICIO");
                notaVO.setNota_descripcion("Inicio de tarea");
            } else {
                tarea.setTare_fechareinicio(new Timestamp(new Date().getTime()));
                notaVO.setNota_nombre("REINICIO");
                notaVO.setNota_descripcion("Reinicio de tarea");
            }
            tarea.setTare_estado("EJECUCION");
            notaVO.setTareaVO(tarea);
            notaVO.setNota_fecharegistro(new Timestamp(new Date().getTime()));
            this.notaDAOImp.registrar(notaVO);
        } else {
            throw new RuntimeException("No se pudo encontrar el nro de tarea:" + idtarea);
        }

    }

    public void finalizarTarea(HttpServletRequest request, int idtarea) {
        TareaVO tarea = this.tareaDAOImp.consultar(idtarea);
        if (tarea != null) {
            NotaVO notaVO = new NotaVO();
            notaVO.setTipoNotaVO(this.tipoNotaDAOImp.consultar(1));
            notaVO.setNota_nombre("FIN");
            notaVO.setNota_descripcion("Fin de tarea");
            String dias = request.getParameter("dias_" + idtarea);
            String horas = request.getParameter("horas_" + idtarea);
            String minutos = request.getParameter("minutos_" + idtarea);
            String segundos = request.getParameter("segundos_" + idtarea);
            String centesimas = request.getParameter("centesimas_" + idtarea);
            tarea.setTare_dias(Integer.parseInt(dias));
            tarea.setTare_horas(Integer.parseInt(horas));
            tarea.setTare_minutos(Integer.parseInt(minutos));
            tarea.setTare_segundos(Integer.parseInt(segundos));
            tarea.setTare_centesimas(Integer.parseInt(centesimas));
            tarea.setTare_fechafin(new Timestamp(new Date().getTime()));
            tarea.setTare_estado("FINALIZADA");
            notaVO.setTareaVO(tarea);
            notaVO.setNota_fecharegistro(new Timestamp(new Date().getTime()));
            this.notaDAOImp.registrar(notaVO);
        } else {
            throw new RuntimeException("No se pudo encontrar la tarea");
        }
    }

    public Object listarTareasUsuarioPorEstados(String nombreUsuario, String[] estados) {
        UsuarioVO usuarioVO = this.consultarUsuario(nombreUsuario);
        ArrayList listatareas = (ArrayList) tareaDAOImp.listarTareasUsuario(usuarioVO, estados);
        return listatareas;
    }

    public Object consultarTareaUsuarioEjecucion(UsuarioVO usuarioVO) {
        TareaVO tareaVO = null;
        if (usuarioVO != null) {
            ArrayList listaTareas = (ArrayList) tareaDAOImp.listarTareasUsuario(usuarioVO, new String[]{"EJECUCION"});
            if (listaTareas != null && listaTareas.size() == 1) {
                tareaVO = (TareaVO) listaTareas.get(0);
            } else if (listaTareas != null && listaTareas.size() > 1) {
                throw new RuntimeException("Existe mas de una tarea en ejecucion");
            }
        } else {
            throw new RuntimeException("Usuario nulo");
        }
        System.out.println("consultarTareaUsuarioEjecucion -> " + tareaVO);
        return tareaVO;
    }

    public void establecerTiempoConsumido(TareaVO tarea) {
        Calendar fechaInicio = Calendar.getInstance();
        Calendar fechaHoy = Calendar.getInstance();
        System.out.println("fechaHoy = " + fechaHoy.getTime());
        System.out.println("fechaInicio = " + new Date(tarea.getTare_fechainicio().getTime()));
        fechaInicio.setTime(new Date(tarea.getTare_fechainicio().getTime()));
        long totalDias = 0;
        long totalHoras = 0;
        long totalMinutos = 0;
        long totalSegundosRestantes = 0;
        long totalSegundosConsumidos = this.obtenerSegundosConsumidos(fechaInicio, fechaHoy);
        totalDias = (fechaHoy.getTime().getTime() - fechaInicio.getTime().getTime()) / (1000 * 60 * 60 * 24);
        System.out.println("totalDias = " + totalDias);
        tarea.setTare_dias(totalDias);
        totalSegundosRestantes = totalSegundosConsumidos - (tarea.getTare_dias() * SEGUNDOS_POR_DIA);
        System.out.println("totalSegundosRestantes(1) : " + totalSegundosRestantes);
        totalHoras = totalSegundosRestantes / SEGUNDOS_POR_HORA;
        System.out.println("Totalhoras = " + totalHoras);
        tarea.setTare_horas(totalHoras);
        totalSegundosRestantes = (totalSegundosConsumidos - (tarea.getTare_dias() * SEGUNDOS_POR_DIA)) - (tarea.getTare_horas() * SEGUNDOS_POR_HORA);
        System.out.println("totalSegundosRestantes(2) : " + totalSegundosRestantes);
        totalMinutos = totalSegundosRestantes / SEGUNDOS_POR_MINUTO;
        System.out.println("totalMinutos = " + totalMinutos);
        tarea.setTare_minutos(totalMinutos);
        totalSegundosRestantes = (totalSegundosConsumidos - (tarea.getTare_dias() * SEGUNDOS_POR_DIA)) - (tarea.getTare_horas() * SEGUNDOS_POR_HORA) - (tarea.getTare_minutos() * SEGUNDOS_POR_MINUTO);
        System.out.println("totalSegundos = " + totalSegundosRestantes);
        tarea.setTare_segundos(totalSegundosRestantes);
    }

    public long obtenerSegundosConsumidos(Calendar fechaInicial, Calendar fechaFinal) {
        long totalSegundos = 0;
        totalSegundos = ((fechaFinal.getTimeInMillis() - fechaInicial.getTimeInMillis()) / 1000);
        System.out.println("Total segundos consumidas: " + totalSegundos);
        return totalSegundos;
    }

    public void verificarTareaEjecucionUsuario(UsuarioVO usuarioVO) {
        TareaVO tareaEjecucionVO = (TareaVO) this.consultarTareaUsuarioEjecucion(usuarioVO);
        if (tareaEjecucionVO != null) {
            this.establecerTiempoConsumido(tareaEjecucionVO);
            usuarioVO.setTareaEjecionVO(tareaEjecucionVO);
        } else {
            System.out.println("el usuario no tiene tareas en ejecucion");
        }
    }

    public UsuarioVO cargarUsuario(String nombreUsuario) {
        UsuarioVO usuarioVO = this.consultarUsuario(nombreUsuario);
        this.verificarTareaEjecucionUsuario(usuarioVO);
        usuarioVO.setTareas((List<TareaVO>) this.listarTareasUsuarioPorEstados(usuarioVO.getUsua_usuario(), new String[]{"PENDIENTE", "EJECUCION"}));
        return usuarioVO;
    }

    public List<TareaVO> listarTareas(TareaVO tareaVO) {
        ArrayList lista = (ArrayList) tareaDAOImp.listar(tareaVO);
        System.out.println("listaTareasFiltradas"+lista);
        return lista;
    }

}
