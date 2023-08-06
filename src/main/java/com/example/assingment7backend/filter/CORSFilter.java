package com.example.assingment7backend.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(filterName = "CORSFilter",urlPatterns = "/*")
public class CORSFilter implements Filter {
    public void init(FilterConfig filterConfig){
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("CrossFilter");
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Allow requests from any origin
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");

        // Allow specific HTTP methods (e.g., GET, POST, OPTIONS, etc.)
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");

        // Allow specific HTTP headers
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        httpResponse.setHeader("Access-Control-Expose-Headers", "Content-Type");
        // Enable CORS credentials (if required, set to "true")
        httpResponse.setHeader("Access-Control-Allow-Credentials", "false");

        // Set the max age for preflight requests (cache the options response)
        httpResponse.setHeader("Access-Control-Max-Age", "3600");

        // Continue the filter chain
        chain.doFilter(request, httpResponse);
    }

    /*    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        System.out.println("CORS filter");
        String origin = req.getHeader("Origin");
        if(origin.contains("http://localhost:63342/Assingmnet_07/Assingmnet_07/index.html?_ijt=kr89dqh5883jshn0jnk77gs3fh&_ij_reload=RELOAD_ON_SAVE")){
            System.out.println("CORS OK");
            res.setHeader("Access-Control-Allow-Origin",origin);
            res.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,HEADER");
            res.setHeader("Access-Control-Allow-Headers", "Content-Type");
            res.setHeader("Access-Control-Expose-Headers","Content-Type");
        }
        chain.doFilter(req,res);
}*/
    /*protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain){
        String origin =request.getHeader("Origin");
        if (origin.contains(""))

    }*/
    public void destroy() {

    }
}
