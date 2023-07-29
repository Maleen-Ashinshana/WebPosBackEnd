package com.example.assingment7backend.service.util;

import com.example.assingment7backend.dto.Customer;
import com.example.assingment7backend.entity.CustomerEntity;

public class Conveter {
    public Customer fromCustomer(CustomerEntity  customerEntity){
        System.out.println(customerEntity.toString());
        return new Customer(customerEntity.getCustomerId(), customerEntity.getCustomerName(), customerEntity.getCustomerAddress(), customerEntity.getCustomerSalary());
    }
    public CustomerEntity toCustomer(Customer customer){
        System.out.println(customer.toString());
        return new CustomerEntity(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerSalary());
    }
}
