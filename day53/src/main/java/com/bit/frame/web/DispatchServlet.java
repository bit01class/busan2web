package com.bit.frame.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet extends HttpServlet {
	Map<String,Controller> handler=new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		Map<String,String> mapping=new HashMap<>();
		System.out.println(config.getServletName());
		String fname=config.getServletName()!=null?config.getServletName():"bit";
		URL res = config.getServletContext().getClassLoader().getResource(fname+".properties");
		Properties prop=new Properties();
		try {
			prop.load(res.openStream());
			Set<Entry<Object, Object>> entrys = prop.entrySet();
			for(Entry<Object, Object> entry:entrys) {
				mapping.put(entry.getKey().toString(), entry.getValue().toString());
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Set<Entry<String, String>> entrys = mapping.entrySet();
		Iterator<Entry<String, String>> ite = entrys.iterator();
		try {
			while(ite.hasNext()) {
				Entry<String,String> entry=ite.next();
			Controller controller=(Controller) Class.forName(entry.getValue())
											.newInstance();
			handler.put(entry.getKey(), controller);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doDo(req, resp);
	}
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// handler map
		String url=req.getRequestURI();
		url=url.substring(req.getContextPath().length());
		
		Controller controller=handler.get(url);
		String viewName=controller.execute(req);
		// view Resolve
		if(viewName.startsWith("redirect:")) {
			resp.sendRedirect(viewName.substring("redirect:".length()));
			return;
		}
		String prefix="/WEB-INF/views/";
		String suffix=".jsp";
		req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);
	}
}









