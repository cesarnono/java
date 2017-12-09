/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceamce.salika.dao;

import com.ceamce.salika.model.TipoNotaVO;
import java.util.List;

/**
 *
 * @author claudia
 */
public interface GenericoDAO<T> {

    public List<T> obtenerTodos();

    public void registrar(T ob);

    public void eliminar(T ob);

    public T consultar(int id);

    public void actualizar(T ob);

}
