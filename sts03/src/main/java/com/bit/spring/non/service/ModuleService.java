package com.bit.spring.non.service;

import com.bit.spring.non.module.Module;
import com.bit.spring.non.module.Module1;
import com.bit.spring.non.module.Module2;

public class ModuleService {
	Module module;
	
	
	public ModuleService() {
	}
	public ModuleService(Module module) {
		this.module=module;
	}
	
	public void setModule(Module module) {
		this.module = module;
	}

	public void work() {
		module.func1();
	}
}
