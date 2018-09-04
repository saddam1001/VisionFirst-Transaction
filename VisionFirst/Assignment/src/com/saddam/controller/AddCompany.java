package com.saddam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saddam.bean.CompanyBean;
import com.saddam.dao.Dao;

@WebServlet("/AddCompany")
public class AddCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCompany() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyName = request.getParameter("companyName");
		String companyAddress = request.getParameter("companyAddress");
		String createdBy = request.getParameter("createdBy");
		String actions = null;
		HttpSession session = request.getSession(false);
		String role = (String)session.getAttribute("role");
		String target = null;
		
		if(role.equals("IT_ADMIN")){
			actions = "approved";
		} else {
			actions = "unapproved";
		}
		
		CompanyBean cb = new CompanyBean(companyName, companyAddress, createdBy, actions);
		int inserted = Dao.addDetails(cb);
		if(inserted != 0){
			request.setAttribute("msg", "Company is added successfully!!!");
			if(role.equals("IT_ADMIN")){
				target = "/IT_ADMIN.jsp";
			} else if(role.equals("IT_USER_NORMAL")){
				target = "IT_USER_NORMAL.jsp";
			}
		} else {
			request.setAttribute("msg", "Oops! There is some issue, Please try again");
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
