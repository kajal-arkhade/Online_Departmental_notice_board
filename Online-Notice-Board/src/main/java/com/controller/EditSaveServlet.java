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

@WebServlet("/EditSaveServlet")
public class EditSaveServlet extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   resp.setContentType("text/html");
   PrintWriter out=resp.getWriter();
   
   int id=Integer.parseInt(req.getParameter("id"));
   String name=req.getParameter("name");
   String email=req.getParameter("email");  
   String password=req.getParameter("password");
   String mobile=req.getParameter("mobile");
   String city=req.getParameter("city");
   
   Student stud= new Student();
   
   stud.setId(id);
   stud.setName(name);
   stud.setEmail(email);
   stud.setPassword(password);
   stud.setMobile(mobile);
   stud.setCity(city);
   
   int status=StudentDao.UpdateStudent(stud);
   if (status>0) {
	resp.sendRedirect("ViewServlet");
}
   else {
	out.println("Unable to update Record");
}
   }
}
