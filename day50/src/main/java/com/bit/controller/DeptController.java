package com.bit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.DeptDao;
import com.bit.model.DeptDto;

@WebServlet("/api/dept/*")
public class DeptController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] arr=req.getRequestURI().split("/");
		int deptno=Integer.parseInt(arr[arr.length-1]);
		System.out.println(req.getParameter("dname"));
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setHeader("Access-Control-Allow-Methods","GET");
		resp.setContentType("application/json; charset=utf8");
		try(
				PrintWriter out=resp.getWriter();
				){
			DeptDao dao=new DeptDao();
			out.print("{\"dept\":");
			out.print(dao.selectOne(deptno));
			out.print("}");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String[] params=br.readLine().split("&");
		DeptDto bean=new DeptDto();
		for(String param : params) {
			if(param.startsWith("deptno=")) {
				param=param.replace("deptno=", "");
				bean.setDeptno(Integer.parseInt(param));
			}else if(param.startsWith("dname=")) {
				param=param.replace("dname=", "");
				bean.setDname(param);
			}else if(param.startsWith("loc=")) {
				param=param.replace("loc=", "");
				bean.setLoc(param);
			}
		}
		br.close();
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setHeader("Access-Control-Allow-Methods","put");
		try {
			DeptDao dao=new DeptDao();
			dao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] arr=req.getRequestURI().split("/");
		int deptno=Integer.parseInt(arr[arr.length-1]);
		System.out.println(req.getRequestURI());
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setHeader("Access-Control-Allow-Methods","delete");
	}
}








