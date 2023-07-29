package com.example.assingment7backend.dto;

public class ItemDTO {
    private String itemCode;
    private String name;
    private int price;
    private int qty;

    public ItemDTO() {
    }

    public ItemDTO(String itemCode, String name, int price, int qty) {
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
