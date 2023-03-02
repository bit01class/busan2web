package com.bit.spring.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Module6 implements Module {
	Map<String,String> map;
	Properties props;
	
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public void setProps(Properties props) {
		this.props = props;
	}

	@Override
	public void func() {
//		for(Entry<Object,Object> entry :props.entrySet())
//			System.out.println(entry.getKey()+"="+entry.getValue());
		
		Set<Entry<String, String>> entrys = map.entrySet();
		for(Entry<String,String> entry:entrys) 
			System.out.println("key:"+entry.getKey()+", val:"+entry.getValue());
	}

}








