package co.com.test;


import co.com.dao.EntityDao;
import co.com.domain.Address;
import co.com.domain.Asignation;
import co.com.domain.Contact;
import co.com.domain.Course;
import co.com.domain.Student;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jpatarroyo
 */
public class TestMain {

    public static void main(String[] args) {
        System.out.println("******************************");
        EntityDao<Student> studentDao = new EntityDao<>(Student.class);
        System.out.println("Students: ");
        print(studentDao.getAll("Student"));
        System.out.println("******************************");
        System.out.println("Address: ");
        EntityDao<Address> addressDao = new EntityDao<>(Address.class);
        print(addressDao.getAll("Address"));
        System.out.println("******************************");
        System.out.println("Contact: ");
        EntityDao<Contact> contactDao = new EntityDao<>(Contact.class);
        print(contactDao.getAll("Contact"));
        System.out.println("******************************");
        System.out.println("Courses: ");
        EntityDao<Course> courseDao = new EntityDao<>(Course.class);
        print(courseDao.getAll("Course"));
        System.out.println("******************************");
        System.out.println("Asignations: ");
        EntityDao<Asignation> asignationDao = new EntityDao<>(Asignation.class);
        print(asignationDao.getAll("Asignation"));
        System.out.println("******************************");
    }

    private static void print(List list) {
        list.forEach(item -> {
            System.out.println("item = " + item);
        });
    }
}
