package com.example.assingment7backend.service.customer;

import com.example.assingment7backend.dto.Customer;
import com.example.assingment7backend.dto.ItemDTO;
import com.example.assingment7backend.service.exception.DuplicateException;
import com.example.assingment7backend.service.util.SuperSevice;

public interface ItemService extends SuperSevice {
    boolean saveItem(ItemDTO itemDTO) throws DuplicateException;
}
