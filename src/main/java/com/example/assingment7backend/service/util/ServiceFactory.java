package com.example.assingment7backend.service.util;


import com.example.assingment7backend.service.customer.IMPL.CustomerServiceIMPL;


import java.sql.SQLException;

public class ServiceFactory {
    private  static ServiceFactory serviceFactory;

    public ServiceFactory() {
    }
    public  static  ServiceFactory getInstance(){
        return serviceFactory==null?(serviceFactory=new ServiceFactory()):serviceFactory;

    }
    public   SuperSevice getService(ServiceTypes serviceTypes) throws SQLException, ClassNotFoundException {
        switch (serviceTypes){
            case CUSTOMER:
                return new CustomerServiceIMPL();
           /* case STUDENT:
                return new StudentServiceIMPL();
            case ROOM:
                return new RoomServiceimpl();
            case RESEVATION:
                return new ReservationServiceIMPL();*/
            default:
                return null;
        }
    }
}
