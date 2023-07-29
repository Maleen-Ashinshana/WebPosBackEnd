package com.example.assingment7backend;

import com.example.assingment7backend.dto.Customer;
import com.example.assingment7backend.entity.CustomerEntity;
import com.example.assingment7backend.service.customer.CustomerService;
import com.example.assingment7backend.service.util.ServiceFactory;
import com.example.assingment7backend.service.util.ServiceTypes;
import com.example.assingment7backend.util.FactoryConfiguration;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private CustomerEntity customer;
    public CustomerService customerService;

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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("jasdbuhjbvuiabvui");
        Jsonb jsonb=JsonbBuilder.create();
        Customer customerDTO=jsonb.fromJson(request.getReader(),Customer.class);
        /*Customer customerDto=new Customer(jsonb.fromJso);*/
        System.out.println(customerDTO+"aaaaa");
        boolean saved= customerService.saveCustomer(customerDTO);
        if (saved){
            System.out.println("Done");
        }else {
            System.out.println("No");
        }

    }
    public void destroy() {
    }
}