package com.example.assingment7backend.service.util;

import com.example.assingment7backend.dto.Customer;
import com.example.assingment7backend.dto.ItemDTO;
import com.example.assingment7backend.entity.CustomerEntity;
import com.example.assingment7backend.entity.ItemEntity;

public class Conveter {
    public Customer fromCustomer(CustomerEntity  customerEntity){
        System.out.println(customerEntity.toString());
        return new Customer(customerEntity.getCustomerId(), customerEntity.getCustomerName(), customerEntity.getCustomerAddress(), customerEntity.getCustomerSalary());
    }
    public CustomerEntity toCustomer(Customer customer){
        System.out.println(customer.toString());
        return new CustomerEntity(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerSalary());
    }

    public ItemDTO fromItem(ItemEntity itemEntity){
        System.out.println(itemEntity.toString());
        return new ItemDTO(itemEntity.getItemCode(),itemEntity.getItemName(), itemEntity.getItemPrice(), itemEntity.getQty() );
    }
    public ItemEntity toItem(ItemDTO itemDTO){
        System.out.println(itemDTO.toString());
        return new ItemEntity(itemDTO.getItemCode(),itemDTO.getItemName(),itemDTO.getItemPrice(), itemDTO.getQty());
    }
}
