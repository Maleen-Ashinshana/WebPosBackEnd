package com.example.assingment7backend.service.customer.IMPL;

import com.example.assingment7backend.dao.custome.CustomerDAO;
import com.example.assingment7backend.dao.util.DAOFactory;
import com.example.assingment7backend.dao.util.DaoTypes;
import com.example.assingment7backend.dto.Customer;
import com.example.assingment7backend.entity.CustomerEntity;
import com.example.assingment7backend.service.customer.CustomerService;
import com.example.assingment7backend.service.exception.DuplicateException;
import com.example.assingment7backend.service.exception.NotFoundException;
import com.example.assingment7backend.service.util.Conveter;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public Customer searchCustomer(String id) throws NotFoundException {
        Optional<CustomerEntity> customerEntity= Optional.ofNullable(customerDAO.search(id));
        if (!customerEntity.isPresent())throw new NotFoundException("Student No Found") ;
        return conveter.fromCustomer(customerEntity.get());
    }

    @Override
    public boolean updateCustomer(Customer customer) throws NotFoundException {
        return customerDAO.update(new CustomerEntity(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerSalary()));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDAO.getAll().stream().map(student -> conveter.fromCustomer(student)).collect(Collectors.toList());
    }
}
