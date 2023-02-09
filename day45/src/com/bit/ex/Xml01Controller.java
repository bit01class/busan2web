package com.bit.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Xml01Controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("cnt");
		if(param==null)param="1";
		int cnt=Integer.parseInt(param);
		PrintWriter out = resp.getWriter();
		try {
			out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			out.println("<stus>");
			for(int i=0; i<cnt; i++) {
				out.println("<stu>");
				out.println("	<num>"+(i+1)+"</num>");
				out.println("	<name>user"+(i+1)+"</name>");
				out.println("	<kor>9"+(i+1)+"</kor>");
				out.println("	<eng>8"+(i+1)+"</eng>");
				out.println("	<math>7"+(i+1)+"</math>");
				out.println("</stu>");
			}
			out.println("</stus>");
		}finally {
			if(out!=null)out.close();
		}
	}
}








