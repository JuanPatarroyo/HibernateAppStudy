/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.test;

import co.com.domain.Contact;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jpatarroyo
 */
public class GetPersistence {
    
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
            EntityManager em = emf.createEntityManager();
            Contact contact = null;
            // Get database object with id 3
            contact = em.find(Contact.class, 3);
            // Detached state
            System.out.println("contact = " + contact);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
}
