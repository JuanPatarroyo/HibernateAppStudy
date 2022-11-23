/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.dao;

import co.com.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author jpatarroyo
 */
public class PersonDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonDAO() {
        emf = Persistence.createEntityManagerFactory("HibernateConfiguration");
        em = emf.createEntityManager();
    }

    public void getAll() {
        String sql = "SELECT p FROM Person p";
        Query query = em.createQuery(sql);
        List<Person> people = query.getResultList();
        people.forEach(person -> {
            System.out.println("person = " + person);
        });
    }

    public void insert(Person person) {
        try {
            em.getTransaction().begin(); // Start transaction
            em.persist(person);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Person person) {
        try {
            em.getTransaction().begin(); // Start transaction
            em.merge(person);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            em.getTransaction().rollback();
        }
    }

    public Person findPersonById(Person p) {
        return em.find(Person.class, p.getIdPerson());
    }
    
    public void deletePerson(Person person){
        try {
            em.getTransaction().begin(); // Start transaction
            em.remove(em.merge(person));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            em.getTransaction().rollback();
        }
    }
}
