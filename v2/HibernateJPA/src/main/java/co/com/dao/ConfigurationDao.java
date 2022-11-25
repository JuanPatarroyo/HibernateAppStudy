/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jpatarroyo
 */
public abstract class ConfigurationDao {

    @PersistenceContext
    protected static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String persistenceUnit = "HibernateJpaPU";

    public ConfigurationDao() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(persistenceUnit);
        }
    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }

}
