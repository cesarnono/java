/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceamce.salika.service;

import com.ceamce.salika.dao.NotaDAOImp;
import com.ceamce.salika.model.NotaVO;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cesar Aguirre Vega
 */
@Transactional
@Service
public class NotaService {

    @Autowired
    private NotaDAOImp notaDAOImp;

    public List listarNotas(String idTarea) {
        List<NotaVO> listaNotas = notaDAOImp.listarNotas(idTarea);
        return listaNotas;
    }

    public void actualizarNota(String idNota, String descripcionNota) {
        NotaVO notaVO = notaDAOImp.consultar(Integer.parseInt(idNota));
        if (notaVO != null) {
            //NotaVO notaVOUpdate = new NotaVO();
            //notaVOUpdate.setNota_id(Integer.parseInt(idNota));
            notaVO.setNota_descripcion(descripcionNota);
            //notaVOUpdate.setNota_fecharegistro(notaVO.getNota_fecharegistro());
           // notaVOUpdate.setNota_nombre(notaVO.getNota_nombre());
           // notaVOUpdate.setTipoNotaVO(notaVO.getTipoNotaVO());
            //notaVOUpdate.setTareaVO(notaVO.getTareaVO());
            //notaDAOImp.actualizar(notaVOUpdate);
        }else{
            throw new RuntimeException("No se pudo encontrar el idnota:" + idNota);
        }

    }

}
