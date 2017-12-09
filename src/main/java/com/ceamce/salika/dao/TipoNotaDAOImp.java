/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceamce.salika.dao;

import com.ceamce.salika.model.TipoNotaVO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author César Aguirre Vega
 */

@Repository
public class TipoNotaDAOImp implements GenericoDAO<TipoNotaVO>{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TipoNotaVO> obtenerTodos() {
        return sessionFactory.getCurrentSession().createQuery("from TipoNotaVO").list();
    }

    @Override
    public void registrar(TipoNotaVO ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(TipoNotaVO ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoNotaVO consultar(int id) {
      return (TipoNotaVO) sessionFactory.getCurrentSession().get(TipoNotaVO.class, id);
    }

    @Override
    public void actualizar(TipoNotaVO ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
