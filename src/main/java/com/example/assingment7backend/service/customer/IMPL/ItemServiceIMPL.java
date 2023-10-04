package com.example.assingment7backend.service.customer.IMPL;

import com.example.assingment7backend.dao.custome.CustomerDAO;
import com.example.assingment7backend.dao.custome.ItemDAO;
import com.example.assingment7backend.dao.util.DAOFactory;
import com.example.assingment7backend.dao.util.DaoTypes;
import com.example.assingment7backend.dto.Customer;
import com.example.assingment7backend.dto.ItemDTO;
import com.example.assingment7backend.entity.CustomerEntity;
import com.example.assingment7backend.entity.ItemEntity;
import com.example.assingment7backend.service.customer.ItemService;
import com.example.assingment7backend.service.exception.DuplicateException;
import com.example.assingment7backend.service.exception.NotFoundException;
import com.example.assingment7backend.service.util.Conveter;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemServiceIMPL implements ItemService {
    private final ItemDAO itemDAO;
    private final Conveter conveter;

    public ItemServiceIMPL() {
        itemDAO= (ItemDAO) DAOFactory.getInstance().getDAO(DaoTypes.ITEMS);
        conveter=new Conveter();
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO) throws DuplicateException {
        return itemDAO.save(new ItemEntity(itemDTO.getItemCode(),itemDTO.getItemName(), itemDTO.getItemPrice(), itemDTO.getQty()));
    }

    @Override
    public ItemDTO searchItems(String id) throws NotFoundException {
        Optional<ItemEntity> itemEntity= Optional.ofNullable(itemDAO.search(id));
        if (!itemEntity.isPresent())throw new NotFoundException("Student No Found") ;
        return conveter.fromItem(itemEntity.get());
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws NotFoundException {
      return  itemDAO.update(new ItemEntity(itemDTO.getItemCode(),itemDTO.getItemName(), itemDTO.getItemPrice(), itemDTO.getQty()));
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return false;
        /*return itemDAO.delete(id);*/
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return itemDAO.getAll().stream().map(item->conveter.fromItem(item)).collect(Collectors.toList());
    }
}
