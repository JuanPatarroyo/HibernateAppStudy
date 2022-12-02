/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.service;

import co.com.dao.EntityDao;
import co.com.domain.Student;
import java.util.List;

/**
 *
 * @author jpatarroyo
 */
public class EntityService<T> {
    
    private Class<T> type;
    EntityDao<T> entityDao = new EntityDao<>();
    
    public List<T> getAll(String table){
        return entityDao.getAll(table);
    }
    
    public void saveObject(T objectToSave){
        Student student = (Student) objectToSave;
        if(objectToSave != null && student.getIdStudent() != null){
            entityDao.update(objectToSave);
        }else{
            entityDao.insert(objectToSave);
        }
    }
    
    public void deleteObject(T objectToDelete){
        entityDao.delete(objectToDelete);
    }
    
    public T getSpecificObject(T objectToFind, Integer id){
        return entityDao.getById(objectToFind, id);
    }
}
