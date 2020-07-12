/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public abstract class AbstractController <T>{
      public Class<T> entityClass;

    public AbstractController(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    

    public void crear(T enttidad) throws Exception {
        EntityManager em = manejadorDeEntidades();
        try {
            em.getTransaction().begin();
            em.persist(enttidad);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al crear el registro."+e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }

    }

    public void editar(T enttidad) throws Exception {
        EntityManager em = manejadorDeEntidades();
        try {
            em.getTransaction().begin();
            em.merge(enttidad);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al editar el registro.");
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public void destruit(T entity) throws Exception {
        EntityManager em = manejadorDeEntidades();
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al editar el registro.");
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public void encontar(Object o) throws Exception {
        EntityManager em = manejadorDeEntidades();
        try {
            em.getTransaction().begin();
            em.find(entityClass, o);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al editar el registro.");
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

//    public List<T> encontarTodos() {
//        EntityManager em= manejadorDeEntidades();
//        List<T> entidades = new ArrayList<T>();
//        em.getTransaction().begin();
//        String jpql="SELECT o FROM "+entityClass.getSimpleName()+" o";
//        Query q =em.createQuery(jpql);
//        entidades=q.getResultList();
//        return entidades;
//    }
    public List<T> encontarTodos() {

        return encontarTodos(true, -1, -1);

    }
    public List<T> encontarTodos(int maxResult, int firstResult) {

        return encontarTodos(false, maxResult, firstResult);

    }
    public List<T> encontarTodos(boolean all, int maxResult, int firstResult) {
         EntityManager em = manejadorDeEntidades();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        
        cq.select(cq.from(entityClass));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResult);
            q.setFirstResult(firstResult);}
        List<T> lista=q.getResultList();
        em.close();
        return lista;
       

    }

    protected abstract EntityManager manejadorDeEntidades();
}
