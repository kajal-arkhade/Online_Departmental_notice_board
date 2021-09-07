package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Student;
import com.dao.StudentDao;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("<title>Students</title>");
		out.println("<style>");

		out.println("  body  {");
		out.println("background-image: url(image1.jpg);");
		out.println("  background-color: #cccccc;");
		out.println(" background-size:100%;");
		out.println("  }");
		out.println("   </style>");

		out.println("<body>");

		out.println("<h1>Students List</h1>");

		List<Student> list = StudentDao.getAllStudents();

		out.print("<table border='1' width='100%'");

		out.println(
				"<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile<th>City</th></th><th>Edit</th><th>Delete</th></tr>");
		for (Student emp : list) {
			out.println("<tr><td>" + emp.getId() + "</td><td>" + emp.getName() + "</td><td>" + emp.getEmail()
					+ "</td><td>" + emp.getPassword() + "</td>" + "<td>" + emp.getMobile() + "</td><td>" + emp.getCity()
					+ "</td><td><a href='EditServlet?id=" + emp.getId() + "'>Edit</a></td><td><a href='delete?id="
					+ emp.getId() + "'>Delete</a></td></tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}