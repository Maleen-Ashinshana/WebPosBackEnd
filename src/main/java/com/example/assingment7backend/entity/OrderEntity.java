package com.example.assingment7backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Order")
@ToString
public class OrderEntity {
    @Id
    private String orderId;
    private String date;
    @ManyToOne
    @JoinColumn(name = "CId",referencedColumnName = "customerId")
    private CustomerEntity customerEntity;
/*
    public OrderEntity(String orderId, String date, CustomerEntity customerEntity) {
        this.orderId = orderId;
        this.date = date;
        this.customerEntity = customerEntity;
    }*/
}
