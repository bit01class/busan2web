package com.bit.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			out.println("{\"emp\":[");
			for(int i=0; i<5; i++) {
			if(i!=0)out.print(",");
			out.println("{\"empno\":"+(i+1)+",\"ename\":\"user"+(i+1)+"\",\"hiredate\":\"2023-02-0"+(i+1)+"\",\"sal\":1000}");
			}
			out.println("]}");
		}finally {
			if(out!=null)out.close();
		}
	}
}
