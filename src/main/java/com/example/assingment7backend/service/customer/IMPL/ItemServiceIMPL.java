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
import com.example.assingment7backend.service.util.Conveter;

public class ItemServiceIMPL implements ItemService {
    private final ItemDAO itemDAO;
    private final Conveter conveter;

    public ItemServiceIMPL() {
        itemDAO= (ItemDAO) DAOFactory.getInstance().getDAO(DaoTypes.ITEMS);
        conveter=new Conveter();
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO) throws DuplicateException {
        return itemDAO.save(new ItemEntity(itemDTO.getItemCode(),itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQty()));
    }
}
