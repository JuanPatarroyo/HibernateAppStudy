package co.com.test;


import co.com.domain.Contact;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jpatarroyo
 */
public class PersistentCycle {
    
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
            EntityManager em = emf.createEntityManager();
            // 1. Transient state
            Contact contact = new Contact(0);
            contact.setEmail("test");
            contact.setPhone("7542");
            // 2. Persistence state
            em.getTransaction().begin();
            em.persist(contact);
//        em.flush(); // Synchronize pending transactions without final commit
            em.getTransaction().commit();
            // 3. Detached state
            System.out.println("contact " + contact);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
