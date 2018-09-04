package com.saddam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saddam.dao.Dao;

@WebServlet("/Approve")
public class Approve extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Approve() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		int status = Dao.approveDetails(sno);
		if(status != 0){
			request.setAttribute("msg", "Company is Approved successfully!");
		} else {
			request.setAttribute("msg", "Oops!!, There is some issue, Please try again");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/IT_ADMIN.jsp");
		rd.forward(request, response);
	}
}
