/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.test;

import co.com.dao.PersonDAO;
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

    static PersonDAO personDao = new PersonDAO();

    public static void main(String[] args) {
//        getAllSimple();
//        getAllDao();
//        insertObject();
//        updateObject();
        deleteObject();
    }

    private static void getAllSimple() {
        String sql = "SELECT p FROM Person p";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateConfiguration");
        EntityManager entity = factory.createEntityManager();
        Query query = entity.createQuery(sql);
        List<Person> result = query.getResultList();
        result.forEach(item -> {
            System.out.println("item = " + item.toString());
        });
    }

    private static void getAllDao() {
        personDao.getAll();
    }

    private static void insertObject() {
        Person person = new Person("Julio", "Fernandez", "pruebas@correo.com", "123456");
        personDao.insert(person);
    }

    private static void updateObject() {
        Person person = new Person();
        person.setIdPerson(39);
        person = personDao.findPersonById(person);
        System.out.println("person = " + person);
        person.setLastName("Patriota");
        personDao.update(person);
        getAllDao();
    }
    
    private static void deleteObject(){
        Person person = new Person();
        person.setIdPerson(39);
        person = personDao.findPersonById(person);
        System.out.println("person = " + person);
        personDao.deletePerson(person);
        getAllDao();
    }
}
