package com.example.assingment7backend.service.customer;

import com.example.assingment7backend.dto.Customer;
import com.example.assingment7backend.service.exception.DuplicateException;
import com.example.assingment7backend.service.exception.NotFoundException;
import com.example.assingment7backend.service.util.SuperSevice;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService extends SuperSevice {
    boolean saveCustomer(Customer customer) throws DuplicateException;
    Customer searchCustomer(String id) throws NotFoundException;
    boolean updateCustomer(Customer customer) throws NotFoundException;
    Customer deleteCustomer(Customer customer) throws SQLException,ClassNotFoundException;
    List<Customer> getAllCustomer();
}
