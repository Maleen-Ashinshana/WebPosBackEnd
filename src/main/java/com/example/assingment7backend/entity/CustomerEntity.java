package com.example.assingment7backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Customer")
@ToString
public class CustomerEntity implements SuperEntity {
    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;
    private int customerSalary;

    public CustomerEntity(String customerId) {
        this.customerId = customerId;
    }

    /* @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL);
    private List<OrderEntity> entities=new ArrayList<>();*/
}
