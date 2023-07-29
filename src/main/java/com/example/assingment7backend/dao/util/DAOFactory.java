package com.example.assingment7backend.dao.util;


/*import lk.ijse.hostel.dao.custom.impl.RoomDAOIMPL;
import lk.ijse.hostel.dao.custom.impl.StudentDAOIMPL;
import lk.ijse.hostel.dao.custom.impl.UserDAOIMPL;*/
import com.example.assingment7backend.dao.custome.IMPL.CustomerDAOIMPL;

public class
DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }
    public static DAOFactory getInstance(){
        return  daoFactory==null?(daoFactory=new DAOFactory()):daoFactory;
    }

   public  SuperDAO getDAO(DaoTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOIMPL();
           /* case STUDENT:
                return new StudentDAOIMPL();
            case ROOM:
                return new RoomDAOIMPL();
            case RESEVATION:
                return new ReservaionDAOIMPL();*/
            default:
                return null;
        }
   }
}
