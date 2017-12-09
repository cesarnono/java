/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceamce.salika.service;

import com.ceamce.salika.dao.UsuarioDAOImp;
import com.ceamce.salika.model.UsuarioVO;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cesar Aguirre Vega
 */
@Service
@Transactional
public class UserService {
    
    @Autowired
    UsuarioDAOImp usuarioDAOImp;
    
    public UserService() {
    }
    
    public List<UsuarioVO> listarUsuario() {
        return usuarioDAOImp.obtenerTodos();
    }
    
    public void saveUser(UsuarioVO usuarioVO) {
        if (usuarioVO == null) {
            throw new RuntimeException("Los datos del usuario vienen vacios, no se puede continuar con el proceso"); //To change body of generated methods, choose Tools | Templates.
        }
        usuarioVO.setUsua_fecharegistro(new Timestamp(new Date().getTime()));
        usuarioVO.setUsua_estado("1"); // activo
        this.usuarioDAOImp.registrar(usuarioVO);
    }
    
    public UsuarioVO consultarUsuario(int idUser) {
        UsuarioVO usuarioVO = usuarioDAOImp.consultar(idUser);
        if (usuarioVO == null) {
            throw new RuntimeException("Usuario no encontrado para id: " + idUser);
        }
        return usuarioVO;
    }
    
    public void updateUser(UsuarioVO usuarioVO) {
        if (usuarioVO == null) {
            throw new RuntimeException("Los datos del usuario vienen vacios, no se puede continuar con el proceso"); //To change body of generated methods, choose Tools | Templates.
        }
        this.usuarioDAOImp.actualizar(usuarioVO);
    }
    
    public void deleteUser(int idUser) {
        UsuarioVO usuarioVO = usuarioDAOImp.consultar(idUser);
        if (usuarioVO == null) {
            throw new RuntimeException("Usuario no encontrado para id: " + idUser);
        }
        this.usuarioDAOImp.eliminar(usuarioVO);
    }
    
}
