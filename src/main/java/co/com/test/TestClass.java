/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.test;

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
public class TestClass {
    
    public static void main(String[] args) {
        String sql = "SELECT p FROM Person p";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateConfiguration");
        EntityManager entity = factory.createEntityManager();
        Query query = entity.createQuery(sql);
        List<Person> result = query.getResultList();
        result.forEach(item ->{
            System.out.println("item = " + item.toString());
        });
    }
}
