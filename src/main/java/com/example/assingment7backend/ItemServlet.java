package com.example.assingment7backend;

import com.example.assingment7backend.dto.Customer;
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
    Jsonb jsonb= JsonbBuilder.create();
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
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        if (request.getContentType()==null || !request.getContentType().toLowerCase().startsWith("application/json")){
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        String id=request.getParameter("id");
        if (id!=null){
            ItemDTO  itemDTO=itemService.searchItems(String.valueOf(Integer.parseInt(id)));
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            jsonb.toJson(itemDTO,response.getWriter());
        }else {
            jsonb.toJson(itemService.getAllItem(), response.getWriter());
        }
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getContentType()==null || !request.getContentType().toLowerCase().startsWith("application/json")){
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        ItemDTO itemDTO=jsonb.fromJson(request.getReader(),ItemDTO.class);
        try {
            boolean isDelete= itemService.deleteItem(String.valueOf(itemDTO));
            if (isDelete){
                System.out.println("Delete SuccessFull");
            }else{
                System.out.println("No");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void destroy() {
    }

}
