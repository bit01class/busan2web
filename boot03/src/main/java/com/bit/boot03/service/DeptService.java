package com.bit.boot03.service;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.bit.boot03.model.DeptDao;
import com.bit.boot03.model.DeptVo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class DeptService {

	private final SqlSessionFactory factory;
	
	public List<DeptVo> selectAll(){
		log.debug("call");
		return factory.openSession().getMapper(DeptDao.class).findAll();
	}
	
}









