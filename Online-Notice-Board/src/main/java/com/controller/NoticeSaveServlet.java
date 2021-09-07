package com.controller;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.beans.Notice;
import com.dao.NoticeDao;  
@WebServlet("/NoticeSaveServlet")  
public class NoticeSaveServlet extends HttpServlet {  
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String date=request.getParameter("date"); 
        String subject=request.getParameter("subject");  
        String notice=request.getParameter("notice");  
       
        Notice e=new Notice();
        
        e.setDate(date);  
       
        e.setSubject(subject); 
        e.setNotice(notice);  
        
         
        
        int status=NoticeDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("AdminOperation.jsp").include(request, response);  
        }else{  
            out.println("<p>Sorry! unable to save record</p>");  
            request.getRequestDispatcher("AddNotice.jsp").include(request, response);  
        }  
          
        out.close();  
    }  
  
}