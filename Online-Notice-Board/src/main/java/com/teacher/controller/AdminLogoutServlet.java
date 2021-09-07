package com.teacher.controller;


import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
@WebServlet("/adminlogout")
public class AdminLogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public AdminLogoutServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
             
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
            dispatcher.forward(request, response);
        }
    }
}