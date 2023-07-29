package com.example.assingment7backend.service.customer;

import com.example.assingment7backend.dto.Customer;
import com.example.assingment7backend.service.exception.DuplicateException;
import com.example.assingment7backend.service.util.SuperSevice;

public interface CustomerService extends SuperSevice {
    boolean saveCustomer(Customer customer) throws DuplicateException;
}
