package com.bit.struts.action;

import java.sql.SQLException;
import java.util.List;

import com.bit.struts.model.DeptDao;
import com.bit.struts.model.DeptVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class ListAction implements ModelDriven<DeptVo> {
	DeptDao dao=new DeptDao();
	List<DeptVo> list;
	
	public List<DeptVo> getList() {
		return list;
	}

	public String deptList() throws Exception {
		list=dao.findAll();
		return Action.SUCCESS;
	}
	
	
	
	public String addDept() throws Exception{
		dao.insertOne(bean);
		return Action.SUCCESS;
	}
	
	public String detail() {
		try {
			bean=dao.findOne(bean.getDeptno());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	public String edit() throws SQLException {
		dao.updateOne(bean);
		return Action.SUCCESS;
	}
	
	public String delete() throws SQLException {
		dao.deleteOne(bean.getDeptno());
		return Action.SUCCESS;
	}

	DeptVo bean = new DeptVo();

	public DeptVo getBean() {
		return bean;
	}
	@Override
	public DeptVo getModel() {
		return bean;
	}

}











