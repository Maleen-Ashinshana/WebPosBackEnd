package com.example.assingment7backend.dao.custome.IMPL;

import com.example.assingment7backend.ConstraintViolationException;
import com.example.assingment7backend.dao.custome.CustomerDAO;
import com.example.assingment7backend.entity.CustomerEntity;
import com.example.assingment7backend.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            session.update(entity);
            transaction.commit();
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }

    }

    @Override
    public boolean delete(String id) {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            CustomerEntity ct=session.load(CustomerEntity.class,id);
            session.delete(ct);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public CustomerEntity search(String s) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            CustomerEntity ct=session.find(CustomerEntity.class,s);
            transaction.commit();
            return new CustomerEntity(s, ct.getCustomerName(), ct.getCustomerAddress(), ct.getCustomerSalary());
        }catch (Exception e){
            e.printStackTrace();
            //transaction.rollback();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public CustomerEntity findType(String type) throws ConstraintViolationException {
        return null;
    }

    @Override
    public List<CustomerEntity> getAll() {

        Session session=FactoryConfiguration.getInstance().getSession();
        List<CustomerEntity> list;
        try {
            Query query=session.createQuery("from CustomerEntity ");
            list=query.list();
            for (CustomerEntity customerEntity:list) {
                System.out.println(customerEntity.getCustomerId());
            }
            System.out.println(list);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
