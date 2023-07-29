package com.example.assingment7backend.dao.custome.IMPL;

import com.example.assingment7backend.ConstraintViolationException;
import com.example.assingment7backend.dao.custome.CustomerDAO;
import com.example.assingment7backend.entity.CustomerEntity;
import com.example.assingment7backend.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAOIMPL implements CustomerDAO {
    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public boolean save(CustomerEntity entity) throws ConstraintViolationException {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();;
            return false;
        }finally {
            session.close();
        }

    }

    @Override
    public boolean update(CustomerEntity entity) throws ConstraintViolationException {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public CustomerEntity search(String s) throws ConstraintViolationException {
        return null;
    }

    @Override
    public CustomerEntity findType(String type) throws ConstraintViolationException {
        return null;
    }

    @Override
    public List<CustomerEntity> getAll() {
        return null;
    }
}
