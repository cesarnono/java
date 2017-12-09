/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceamce.salika.dao;

import com.ceamce.salika.model.UsuarioVO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cesar Aguirre Vega
 */
@Repository
public class UsuarioDAOImp implements GenericoDAO<UsuarioVO>{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UsuarioVO> obtenerTodos() {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UsuarioVO.class);
        return crit.list();
    }

    @Override
    public void registrar(UsuarioVO ob) {
       sessionFactory.getCurrentSession().save(ob);
    }

    @Override
    public void eliminar(UsuarioVO ob) {
      sessionFactory.getCurrentSession().delete(ob);
    }

    @Override 
    public UsuarioVO consultar(int id) {
      Criteria crit = sessionFactory.getCurrentSession().createCriteria(UsuarioVO.class);
      crit.add(Restrictions.eq("usua_id", id));
      return (UsuarioVO) crit.uniqueResult();
      
    }

    @Override
    public void actualizar(UsuarioVO ob) {
      sessionFactory.getCurrentSession().update(ob);
    }
    
    public UsuarioVO findByUsername(String usuario) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(UsuarioVO.class)
				.add(Restrictions.eq("usua_usuario", usuario));
		
		return (UsuarioVO) crit.uniqueResult();
	}

}
