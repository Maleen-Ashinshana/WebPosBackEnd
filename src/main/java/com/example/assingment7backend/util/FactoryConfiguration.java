package com.example.assingment7backend.util;


import com.example.assingment7backend.entity.CustomerEntity;
import com.example.assingment7backend.entity.ItemEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    public static FactoryConfiguration factoryConfiguration;

    private SessionFactory sessionFactory;
    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerEntity.class)
                .addAnnotatedClass(ItemEntity.class);
                /*.addAnnotatedClass(RoomEntity.class)
                .addAnnotatedClass(ReservationEntity.class);*/

        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return (null==factoryConfiguration?factoryConfiguration=new FactoryConfiguration():factoryConfiguration);
    }

    public Session getSession(){
        return sessionFactory.openSession();//returns a hibernate Session
    }
}
