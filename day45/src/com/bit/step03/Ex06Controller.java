package com.bit.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex06Controller extends HttpServlet {

//	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		PrintWriter out = res.getWriter();
//		try {
//			out.println("<h1>DoGet page</h1>");
//		}finally {
//			if(out!=null)out.close();
//		}
//	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		try {
			out.println("<h1>DoPost page</h1>");
		}finally {
			if(out!=null)out.close();
		}
	}
}










