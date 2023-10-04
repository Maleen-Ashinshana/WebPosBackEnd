package com.example.assingment7backend;

import com.example.assingment7backend.dto.Customer;
import com.example.assingment7backend.entity.CustomerEntity;
import com.example.assingment7backend.service.customer.CustomerService;
import com.example.assingment7backend.service.util.ServiceFactory;
import com.example.assingment7backend.service.util.ServiceTypes;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class CustomerServlet extends HttpServlet {
    private String message;
    private CustomerEntity customer;
    public CustomerService customerService;
    Jsonb jsonb=JsonbBuilder.create();
    @Override
    public void init() {
        try {
            customerService= (CustomerService) ServiceFactory.getInstance().getService(ServiceTypes.CUSTOMER);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        message = "Hello World!";
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*if (request.getContextPath()==null|| request.getContentType().toLowerCase().startsWith("application/json")){
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }*/

        Customer customerDTO=jsonb.fromJson(request.getReader(),Customer.class);
        /*Customer customerDto=new Customer(jsonb.fromJso);*/
        System.out.println(customerDTO.getCustomerId());
        boolean saved= customerService.saveCustomer(customerDTO);
        if (saved){
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.setContentType("application/json");
            jsonb.toJson(customerDTO, response.getWriter());
        }else {
            System.out.println("No");
        }

    }
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        if (request.getContentType()==null || !request.getContentType().toLowerCase().startsWith("application/json")){
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        String id=request.getParameter("id");
        if (id!=null){
            Customer customer1=customerService.searchCustomer(String.valueOf(Integer.parseInt(id)));
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            jsonb.toJson(customer1,response.getWriter());
        }else {
           jsonb.toJson(customerService.getAllCustomer(), response.getWriter());
        }
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getContentType()==null || !request.getContentType().toLowerCase().startsWith("application/json")){
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        Customer customerDTO=jsonb.fromJson(request.getReader(),Customer.class);
        try {
            customerDTO=customerService.deleteCustomer(customerDTO);
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            jsonb.toJson(customerDTO, response.getWriter());
            System.out.println("Yes");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("*****");
//        Customer customer1=jsonb.fromJson(request.getReader(),Customer.class);
       /* try {
            boolean isDelete= customerService.deleteCustomer(String.valueOf(customer1));
            if (isDelete){

                System.out.println("Delete SuccessFull");
            }else{
                System.out.println("No");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/
       /* Customer customerDto=jsonb.fromJson(request.getReader(),Customer.class);
        try {
            customerDto=customerService.deleteCustomer(String.valueOf(customerDto));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/

    }
    @Override
    public void doPut(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Customer customer1=jsonb.fromJson(request.getReader(),Customer.class);

    }



    public void destroy() {
    }
}