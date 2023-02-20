package com.bit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/index.do")
public class IndexController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		System.out.println(session.getId());
		if(session.getAttribute("id")==null) {
		response.sendRedirect("ex01.do");	
		}else {
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
