/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceamce.salika.dao;

import com.ceamce.salika.model.TareaVO;
import com.ceamce.salika.model.UsuarioVO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cesar Aguirre Vega
 */
@Repository
public class TareaDAOImp implements GenericoDAO<TareaVO> {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<TareaVO> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void registrar(TareaVO ob) {
        sessionFactory.getCurrentSession().save(ob);
    }
    
    @Override
    public void eliminar(TareaVO ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public TareaVO consultar(int id) {
        System.out.println("public TareaVO consultar(int id) --> " + id);
        return (TareaVO) sessionFactory.getCurrentSession().get(TareaVO.class, id);
    }
    
    @Override
    public void actualizar(TareaVO ob) {
        sessionFactory.getCurrentSession().update(ob);
    }

//    public List<TareaVO> obtenerTareasUsuario(UsuarioVO usuarioVO) {
//        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TareaVO.class)
//                .setFetchMode("usuario", FetchMode.JOIN)
//                .add(Restrictions.eq("usuario.usua_id", usuarioVO.getUsua_id()))
//                .setResultTransformer(Criteria.ROOT_ENTITY);
//        System.out.println("crit --> " + crit);
//        return crit.list();
//
//    }
    public List<TareaVO> listarTareasUsuario(UsuarioVO usuarioVO, String[] estados) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TareaVO.class)
                .setFetchMode("usuario", FetchMode.JOIN)
                .add(Restrictions.eq("usuario.usua_id", usuarioVO.getUsua_id()))
                .add(Restrictions.in("tare_estado", estados))
                //.add(Restrictions.lt("tare_minutos", 5l))
                .addOrder(Order.desc("tare_fechafin"))
                .setResultTransformer(Criteria.ROOT_ENTITY);
        //System.out.println("crit --> " + crit);
        return crit.list();
        
    }
    
    public List<TareaVO> listar(TareaVO filtroTareaVO) {
        System.out.println(" filtroTareaVO >- " + filtroTareaVO);
        if (filtroTareaVO != null) {
            Criteria crit = sessionFactory.getCurrentSession().createCriteria(TareaVO.class);
            if (filtroTareaVO.getTare_codigo() != null) {
                //System.out.println("codigo -> "+filtroTareaVO.getTare_codigo());
                crit.add(Restrictions.like("tare_codigo", filtroTareaVO.getTare_codigo() + "%"));
            }
            if (filtroTareaVO.getTare_descripcion() != null) {
                // System.out.println("descripcion -> "+filtroTareaVO.getTare_descripcion());
                crit.add(Restrictions.like("tare_descripcion", "%" + filtroTareaVO.getTare_descripcion() + "%"));
            }
            if (filtroTareaVO.getTare_estado() != null) {
                crit.add(Restrictions.eq("tare_estado", filtroTareaVO.getTare_estado()));
            }
            if (filtroTareaVO.getUsuario() != null) {
                System.out.println("filtroTareaVO.getUsuario() --> "+filtroTareaVO.getUsuario());
                crit.add(Restrictions.eq("usuario", filtroTareaVO.getUsuario()));
            }
            if (filtroTareaVO.getTare_fechainicio() != null) {
                crit.add(Restrictions.sqlRestriction("DATE(tare_fechainicio) = "+"DATE('"+filtroTareaVO.getTare_fechainicio()+"')"));
            }
            if (filtroTareaVO.getTare_fechafin() != null) {                
                crit.add(Restrictions.sqlRestriction("DATE(tare_fechafin) = "+"DATE('"+filtroTareaVO.getTare_fechafin()+"')"));
            }            
            crit.addOrder(Order.desc("tare_fechafin"));
            crit.setResultTransformer(Criteria.ROOT_ENTITY);
            return crit.list();
        }
        return null;
    }
    
}
