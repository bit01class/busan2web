package com.bit.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		try {
			out.println("{\"stu\":[");
			for(int i=0; i<5; i++) {
			if(i!=0)out.print(",");
			out.println("{\"num\":"+(i+1)+",\"name\":\"user"+(i+1)+"\",\"kor\":9"+(i+1)+",\"eng\":8"+(i+1)+",\"math\":7"+(i+1)+"}");
			}
			out.println("]}");
		}finally {
			if(out!=null)out.close();
		}
	}
}










