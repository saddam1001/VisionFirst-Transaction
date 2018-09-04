package com.saddam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saddam.bean.CompanyBean;
import com.saddam.dao.Dao;

@WebServlet("/ViewUserCompany")
public class ViewUserCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewUserCompany() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("username");
		
		List<CompanyBean> l = Dao.getDetailsByName(username);
		session.setAttribute("l", l);
		
		RequestDispatcher rd = request.getRequestDispatcher("/normal_user.jsp");
		rd.forward(request, response);
	}
}
