package com.saddam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saddam.dao.Dao;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		HttpSession session = request.getSession(false);
		String role = (String)session.getAttribute("role");
		String target = null;
		int deleted = Dao.delete(sno);
		if(deleted != 0){
			request.setAttribute("msg", "Company record is deleted");
			if(role.equals("IT_ADMIN")){
				target = "/IT_ADMIN.jsp";
			}
			else if(role.equals("IT_USER_NORMAL")){
				target = "/IT_USER_NORMAL.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
