package com.controller;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.beans.Student;
import com.dao.StudentDao;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    /**
	 * 
	 */
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
       
        Student e=new Student();
        
        e.setName(name);  
       
        e.setEmail(email); 
        e.setPassword(password);  
        e.setMobile(mobile);
        e.setCity(city);  
         
        
        int status=StudentDao.save(e);  
        if(status>0){  
           out.print("<p>Registered successfully!</p>");  
            request.getRequestDispatcher("registration.jsp").include(request, response);  
        }else{  
            out.println("<p>Sorry! unable to save record</p>");  
            request.getRequestDispatcher("registration.jsp").include(request, response);  
        }  
          
        out.close();  
    }  
  
}