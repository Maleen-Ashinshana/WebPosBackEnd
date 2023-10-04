package com.example.assingment7backend.dao.custome.IMPL;

import com.example.assingment7backend.ConstraintViolationException;
import com.example.assingment7backend.dao.custome.ItemDAO;
import com.example.assingment7backend.entity.CustomerEntity;
import com.example.assingment7backend.entity.ItemEntity;
import com.example.assingment7backend.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDAOIMPL implements ItemDAO {
    Session session= FactoryConfiguration.getInstance().getSession();
    Transaction transaction=session.beginTransaction();
    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public boolean save(ItemEntity entity) throws ConstraintViolationException {
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
    public boolean update(ItemEntity entity) throws ConstraintViolationException {
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
    public ItemEntity delete(ItemEntity entity) {
        return null;
    }

  /*  @Override
    public boolean delete(String id) {

        try {
            ItemEntity item=session.load(ItemEntity.class,id);
            session.delete(item);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }*/

    @Override
    public ItemEntity search(String id) throws ConstraintViolationException {
        try {
            ItemEntity items=session.find(ItemEntity.class,id);
            transaction.commit();
            return new ItemEntity(id,items.getItemName(), items.getItemPrice(), items.getQty());
        }catch (Exception e){
            e.printStackTrace();
            //transaction.rollback();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public ItemEntity findType(String type) throws ConstraintViolationException {
        return null;
    }

    @Override
    public List<ItemEntity> getAll() {

        List<ItemEntity> itemEntities;
        try {
            Query query=session.createQuery("from ItemEntity ");
            itemEntities=query.list();
            for (ItemEntity itemEntity:itemEntities) {
                System.out.println(itemEntity.getItemCode());
            }
            System.out.println(itemEntities);
            return itemEntities;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
    }
    }
}
