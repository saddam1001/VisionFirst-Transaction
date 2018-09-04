package com.saddam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saddam.bean.RegisterBean;
import com.saddam.dao.Dao;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String role = request.getParameter("role");
		
		RegisterBean rb = new RegisterBean(name,email,mobile,password,username,role);
		int status = Dao.registerUser(rb);
		
		String target = null;
		if(status != 0){
			request.setAttribute("msg", name+" you have been registered successfully");
			target = "/login.jsp";
		} else {
			request.setAttribute("msg", "There is some error, please try again");
			target = "/register.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);		
	}

}
