package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class Ex02Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 
		HttpSession session = req.getSession();
		// 1.
		//session.setAttribute("id", null);
		// 2.
		//session.removeAttribute("id");
		// 3.
		System.out.println(session.getId());
		session.invalidate();
		System.out.println(session.getId());
		
		req.getRequestDispatcher("ex02.jsp").forward(req, resp);
	}
}










