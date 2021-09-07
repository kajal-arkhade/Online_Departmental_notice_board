package com.teacher.controller;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.beans.Admin;
import com.dao.AdminDao;
 

@WebServlet("/AdminSaveServlet")  
public class AdminSaveServlet  extends HttpServlet {  
   
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name"); 
        String email=request.getParameter("email");  
        String password=request.getParameter("password");  
        String mobile=request.getParameter("mobile");  
        String city=request.getParameter("city");  
       
        Admin e=new Admin();
        
        e.setName(name);  
       
        e.setEmail(email); 
        e.setPassword(password);  
        e.setMobile(mobile);
        e.setCity(city);  
         
        
        int status=AdminDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("Admin_registration.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}