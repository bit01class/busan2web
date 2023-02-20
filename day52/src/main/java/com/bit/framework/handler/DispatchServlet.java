package com.bit.framework.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.controller.AddController;
import com.bit.controller.IndexController;
import com.bit.controller.InsertController;
import com.bit.controller.IntroController;
import com.bit.controller.ListController;

public class DispatchServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI();
		uri=uri.substring(req.getContextPath().length());
		Controller controller=null;
		String classInfo=this.getInitParameter(uri);
		
		try {
			Class clz=Class.forName(classInfo);
			controller=(Controller) clz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		String viewName=controller.execute(req);
		if(viewName.startsWith("redirect:")) {
			resp.sendRedirect(viewName.replace("redirect:", ""));
		}else {
			req.getRequestDispatcher("/WEB-INF/views/"+viewName+".jsp")
			.forward(req, resp);
		}
	}

}












