package com.bit.sts06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts06.model.DeptDao;
import com.bit.sts06.model.DeptVo;

import lombok.Setter;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptDao deptDao;
	
	@Override
	public List<DeptVo> selectAll(){
		return deptDao.findAll();
	}

	@Transactional
	@Override
	public void insertOne(DeptVo bean) {
		deptDao.insertOne(bean);
	}

	@Override
	public DeptVo selectOne(int deptno) {
		return deptDao.findObject(deptno);
	}

	@Transactional
	@Override
	public int updateOne(DeptVo bean) {
		return deptDao.updateOne(bean);
	}

	@Transactional
	@Override
	public int deleteOne(int deptno) {
		return deptDao.deleteOne(deptno);
	}
}
