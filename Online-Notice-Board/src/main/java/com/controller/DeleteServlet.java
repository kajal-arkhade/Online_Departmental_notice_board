package com.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
  @Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	int id=Integer.parseInt(req.getParameter("id"));
	
	StudentDao.deleteUser(id);
	res.sendRedirect("ViewServlet");
}
}
