package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

@WebServlet("/upload.do")
public class Ex03Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("ex03.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int max=1024*10;
		String upload=req.getRealPath("/upload");
		System.out.println(upload);
		FileRenamePolicy frp=new DefaultFileRenamePolicy();
		MultipartRequest mreq=new MultipartRequest(req,upload,max,frp);
		String name=mreq.getParameter("name");
		String oldname=mreq.getOriginalFileName("file1");
		String newName=mreq.getFilesystemName("file1");
		req.setAttribute("old", oldname);
		req.setAttribute("new", newName);
		req.getRequestDispatcher("ex04.jsp").forward(req, resp);
	}
}










