package com.saddam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saddam.bean.RegisterBean;
import com.saddam.dao.Dao;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		RegisterBean rb = new RegisterBean();
		rb.setUsername(username);
		rb.setPassword(password);
		
		String target = null;
		
		boolean status = Dao.loginUser(rb);
		session.setAttribute("role", rb.getRole());
		
		if(status != false && rb.getRole().equals("IT_ADMIN")){
			target = "/IT_ADMIN.jsp";
		} else if(status == true && rb.getRole().equals("IT_USER_NORMAL")){
			target = "/IT_USER_NORMAL.jsp";
		} else {
			request.setAttribute("msg", "Please provide valid redentials.");
			target = "/login.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}

}
