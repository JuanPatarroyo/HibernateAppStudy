/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.dao;

import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author jpatarroyo
 */
public class EntityDao<T> extends ConfigurationDao {

    private Class<T> type;
    
    public List<T> getAll(String table) {
        String sql = "SELECT " + table.substring(0, 1) + " FROM " + table + " " + table.substring(0, 1);
        em = getEntityManager();
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    public void insert(T object) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            if (em != null){
                em.close();
            }
        }
    }
    
    public void update(T object) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            if (em != null){
                em.close();
            }
        }
    }
    
    public void delete(T object) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(object));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            if (em != null){
                em.close();
            }
        }
    }
    
    public T getById(T object, Integer idObject){
        em = getEntityManager();
        return em.find(type, idObject);
    }
}
