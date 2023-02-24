package com.bit.struts.action;

import com.opensymphony.xwork2.Action;

public class AddAction implements Action {
	private String title="입력";
	
	public String getTitle() {
		return title;
	}

	@Override
	public String execute() throws Exception {
		return Action.SUCCESS;
	}

}
