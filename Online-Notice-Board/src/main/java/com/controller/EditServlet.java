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
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			out.println("<h1>Update Employee</h1>");
			out.println("<style>");

			out.println("  body  {");
			out.println("background-image: url(image1.jpg);");
			out.println("  background-color: #cccccc;");
			out.println(" background-size:100%;");
			out.println("  }");
			out.println("   </style>");

			out.println("<body>");
			
			int id=Integer.parseInt(req.getParameter("id"));
			
			Student stud=StudentDao.getstudById(id);
			
			
			out.println("<form action='EditSaveServlet' method='post'>");
			out.println("<table>");
			out.println("<tr><td></td><td><input type='hidden' name='id' value='"+stud.getId()+"'></td></tr>");
			out.println("<tr><td>Name:</td><td><input type='text' name='name' value='"+stud.getName()+"'></td></tr>");
			out.println("<tr><td>Email:</td><td><input type='email' name='email' value='"+stud.getEmail()+"'></td></tr>");
			out.println("<tr><td>Password:</td><td><input type='password' name='pass' value='"+stud.getPassword()+"'></td></tr>");
			out.println("<tr><td>Mobile:</td><td><input type='text' name='mobile' value='"+stud.getMobile()+"'></td></tr>");
		out.println("<tr><td>City:</td><td><input type='text' name='city' value='"+stud.getCity()+"'></td></tr>");
		out.println("<tr><td colspan='2'><input type='submit' value='Edit&Save'></td></tr>");
		out.println("</table></form>");
		out.println("</body>");
		out.println("</html>");
	}
}
