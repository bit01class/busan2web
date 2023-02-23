package com.bit.struts.action;

import java.util.List;

import com.bit.struts.model.DeptDao;
import com.bit.struts.model.DeptVo;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {

	private List<DeptVo> list;
	
	public List<DeptVo> getList() {
		return list;
	}

	@Override
	public String execute() throws Exception {
		DeptDao dao=new DeptDao();
		list=dao.findAll();
		return Action.SUCCESS;
	}

}
