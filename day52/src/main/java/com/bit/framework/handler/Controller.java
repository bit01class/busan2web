package com.bit.framework.handler;

import javax.servlet.http.HttpServletRequest;

public interface Controller {

	public String execute(HttpServletRequest req);
}
