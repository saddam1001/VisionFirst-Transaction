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

@WebServlet("/ViewCompany")
public class ViewCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewCompany() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CompanyBean> l = Dao.getAllDetails();
		session.setAttribute("l", l);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
		rd.forward(request, response);
	}
}
