/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.test;

import co.com.domain.Address;
import co.com.domain.Contact;
import co.com.domain.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jpatarroyo
 */
public class CascadeExample {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        Address address = new Address("Jazmin", "24", "Colombia");
        Contact contact = new Contact("123456", "pruebas@test.com");
        Student student = new Student(address, contact, "Yuly", "Martinez");
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        
        System.out.println("student = " + student);
    }
}
