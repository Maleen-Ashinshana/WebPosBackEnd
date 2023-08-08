package com.example.assingment7backend.service.customer;

import com.example.assingment7backend.dto.Customer;
import com.example.assingment7backend.dto.ItemDTO;
import com.example.assingment7backend.service.exception.DuplicateException;
import com.example.assingment7backend.service.exception.NotFoundException;
import com.example.assingment7backend.service.util.SuperSevice;

import java.sql.SQLException;
import java.util.List;

public interface ItemService extends SuperSevice {
    boolean saveItem(ItemDTO itemDTO) throws DuplicateException;

    ItemDTO searchItems(String id) throws NotFoundException;
    boolean updateItem(ItemDTO itemDTO) throws NotFoundException;
    boolean deleteItem(String id) throws SQLException,ClassNotFoundException;
    List<ItemDTO> getAllItem();
}
