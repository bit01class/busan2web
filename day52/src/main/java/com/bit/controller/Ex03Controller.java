package com.bit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class Ex03Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("fname");
		if(name!=null) {
			String path="D:\\webspace\\day52\\download\\";
			
			File f=new File(path+name);
			if(f.exists()) {
				resp.setContentType("application/octet-stream");
				resp.setHeader("Content-Disposition"
						, "attachment; filename=\""+name+"\"");
				try(
						InputStream is=new FileInputStream(f);
						OutputStream os=resp.getOutputStream();
					){
					int cnt=-1;
					while((cnt=is.read())!=-1) {
						os.write(cnt);
					}
				}
			}else {
				resp.setContentType("text/html; charset=utf-8");
				resp.getWriter().append("<h1>파일없음</h1>");
			}
		}
	}
}










