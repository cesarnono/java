/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceamce.salika.dao;

import com.ceamce.salika.model.NotaVO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author César Aguirre Vega
 */
@Repository
public class NotaDAOImp implements GenericoDAO<NotaVO> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<NotaVO> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrar(NotaVO ob) {
        sessionFactory.getCurrentSession().save(ob);
    }

    @Override
    public void eliminar(NotaVO ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NotaVO consultar(int id) {
      return (NotaVO) sessionFactory.getCurrentSession().get(NotaVO.class, id);
    }

    @Override
    public void actualizar(NotaVO ob) {
        sessionFactory.getCurrentSession().update(ob);
    }

    public List<NotaVO> listarNotas(String idTarea) {
        System.out.println("idtarea: " + idTarea);
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(NotaVO.class);
        crit.setFetchMode("tarea", FetchMode.JOIN)
                .add(Restrictions.eq("tareaVO.tare_id", Integer.parseInt(idTarea)))
                .setResultTransformer(Criteria.ROOT_ENTITY);
        //System.out.println("crit.list() --> " + crit.list());
        //Query query = sessionFactory.getCurrentSession().createQuery("from nota");
        for (NotaVO notaVO :(List<NotaVO>) crit.list()) { 
            System.out.println("--> "+notaVO.getTipoNotaVO().getTino_editable());
        }
         return crit.list();
    }

}
