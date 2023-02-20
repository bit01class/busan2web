package com.bit.util.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class Ex01Listener implements ServletContextListener {
	Logger log=Logger.getLogger(this.getClass().getCanonicalName());

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.debug("listen init...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.debug("listen detroy...");
	}

}
