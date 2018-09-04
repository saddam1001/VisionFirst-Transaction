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


@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Edit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno = request.getParameter("sno");
		int sn = Integer.parseInt(sno);
		List<CompanyBean> l = Dao.getDetailsById(sn);
		request.setAttribute("l", l);
		RequestDispatcher rd = request.getRequestDispatcher("/editDetails.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		String cName = request.getParameter("companyName");
		String cAddress = request.getParameter("companyAddress");
		String createdBy = request.getParameter("createdBy");
		String actions = request.getParameter("actions");
		HttpSession session = request.getSession(false);
		String role = (String)session.getAttribute("role");
		
		String target = null;
		CompanyBean cb = new CompanyBean(sno, cName, cAddress, createdBy, actions);
		int inserted = Dao.editDetails(cb);
		if(inserted != 0){
			request.setAttribute("msg", "Company details is edited successfully");
			if(role.equals("IT_ADMIN")){
				target = "/IT_ADMIN.jsp";
			} else if(role.equals("IT_USER_NORMAL")){
				target = "/IT_USER_NORMAL.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}

}
