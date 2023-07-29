package com.example.assingment7backend.dao.util;

import com.example.assingment7backend.ConstraintViolationException;
import com.example.assingment7backend.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO<T extends SuperEntity,ID extends Serializable> extends SuperDAO {
/*    T save(T entity) throws  ConstraintViolationException;
    T update(T entity) throws ConstraintViolationException;
    void delete (String id) throws NotFoundException;
    T search(ID pk)throws ConstraintViolationException;
    List<T> findAll();
    long count();*/

    boolean existByPk(ID pk);
    public boolean save(T  entity) throws ConstraintViolationException;
    public boolean update(T entity)throws ConstraintViolationException;
     public boolean delete(String id) ;
    /*public boolean deleted(T entity) ;*/
             /*NotFoundException*/;
     public T search(ID id) throws ConstraintViolationException;
    public T findType(ID type) throws ConstraintViolationException;
     public List<T> getAll();
}
