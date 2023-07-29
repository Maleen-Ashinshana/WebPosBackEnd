package com.example.assingment7backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Item")
@ToString
public class ItemEntity implements SuperEntity {
    @Id
    private String itemCode;
    private String itemName;
    private int itemPrice;
    private int qty;
}
