package com.example.assingment7backend.service.customer.IMPL;

import com.example.assingment7backend.dao.custome.CustomerDAO;
import com.example.assingment7backend.dao.util.DAOFactory;
import com.example.assingment7backend.dao.util.DaoTypes;
import com.example.assingment7backend.dto.Customer;
import com.example.assingment7backend.entity.CustomerEntity;
import com.example.assingment7backend.service.customer.CustomerService;
import com.example.assingment7backend.service.exception.DuplicateException;
import com.example.assingment7backend.service.util.Conveter;

public class CustomerServiceIMPL implements CustomerService {
    private final CustomerDAO customerDAO;
    private final Conveter conveter;
    public CustomerServiceIMPL(){
        customerDAO= (CustomerDAO) DAOFactory.getInstance().getDAO(DaoTypes.CUSTOMER);
        conveter=new Conveter();
    }
    @Override
    public boolean saveCustomer(Customer customer) throws DuplicateException {
        System.out.println(customer+"**");
        return customerDAO.save(new CustomerEntity(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerSalary()));
    }
}
