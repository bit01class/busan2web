package com.bit.struts.action;

import org.apache.log4j.Logger;

import com.bit.struts.model.DeptDao;
import com.bit.struts.model.DeptVo;
import com.opensymphony.xwork2.Action;

public class DeptAction implements Action {
	Logger log=Logger.getLogger(this.getClass().getCanonicalName());
	String id;
	private DeptVo bean;
	public void setId(String id) {
		this.id = id;
	}
	public DeptVo getBean() {
		return bean;
	}

	@Override
	public String execute() throws Exception {
		log.debug(id);
		DeptDao dao=new DeptDao();
		bean=dao.findOne(id);
		return Action.SUCCESS;
	}

}







