package com.example.assingment7backend;

import com.example.assingment7backend.dto.ItemDTO;
import com.example.assingment7backend.service.customer.ItemService;
import com.example.assingment7backend.service.util.ServiceFactory;
import com.example.assingment7backend.service.util.ServiceTypes;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name = "ItemServlet"/*, value = "/items"*/,urlPatterns = "back")
public class ItemServlet extends HttpServlet {
    public ItemService itemService;

    @Override
    public void init() throws ServletException {
        try {
            itemService = (ItemService) ServiceFactory.getInstance().getService(ServiceTypes.ITEM);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("ItemsMethod");
        Jsonb jsonb= JsonbBuilder.create();
        ItemDTO itemDTO =jsonb.fromJson(request.getReader(),ItemDTO.class);
        /*Customer customerDto=new Customer(jsonb.fromJso);*/
        System.out.println(itemDTO);
        boolean saved= itemService.saveItem(itemDTO);
        if (saved){
            System.out.println("Done");
        }else {
            System.out.println("No");
        }

    }
    public void destroy() {
    }

}
