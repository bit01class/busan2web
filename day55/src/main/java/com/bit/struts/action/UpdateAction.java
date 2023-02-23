package com.bit.struts.action;


import org.apache.log4j.Logger;

import com.bit.struts.model.DeptDao;
import com.opensymphony.xwork2.Action;

public class UpdateAction implements Action {
	Logger log=Logger.getLogger(this.getClass().getCanonicalName());
	int deptno;
	String id,dname,loc;
	public String getId() {
		return id;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String execute() throws Exception {
		DeptDao dao=new DeptDao();
		long cnt=dao.updateOne(id,deptno,dname,loc);
		log.debug(cnt);
		if(cnt>0)
			return Action.SUCCESS;
		return Action.INPUT;
	}

}
