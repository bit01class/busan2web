package com.bit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;

public class DelController extends HttpServlet {
	Logger log=Logger.getLogger("com.bit.controller.DelController");

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info(req.getParameter("idx"));
		int empno=Integer.parseInt(req.getParameter("idx"));
		EmpDao dao=new EmpDao();
		try {
			if(dao.deleteOne(empno)==0) {
				resp.setStatus(resp.SC_BAD_REQUEST);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}








