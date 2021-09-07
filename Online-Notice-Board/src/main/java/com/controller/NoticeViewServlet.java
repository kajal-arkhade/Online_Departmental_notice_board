package com.controller;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.beans.Notice;
import com.dao.NoticeDao;

 
@WebServlet("/NoticeViewServlet")  
public class NoticeViewServlet extends HttpServlet {  
  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
       
       
        out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		 out.println("<h1>Notice Board</h1>");  
		out.println("<style>");

		out.println("  body  {");
		out.println("background-image: url(image1.jpg);");
		out.println("  background-color: #cccccc;");
		out.println(" background-size:100%;");
		out.println("  }");
		out.println("   </style>");

        List<Notice> list=NoticeDao.getAllNotices();  
          
        out.print("<table  border='1' width='100%'");  
        
        
        out.println("<tr><th>ID</th><th>Date</th><th>Subject</th><th>Notice</th></tr>");
    	for (Notice not : list) 
    	{
    		out.println("<tr><td>"+not.getId()+"</td><td>"+not.getDate()+"</td><td>"+not.getSubject()+"</td><td>"+not.getNotice()+"</td>");
    	}
    out.println("</table>");
    
	  out.println("</body>");  
	  out.println("</html>");
}
}