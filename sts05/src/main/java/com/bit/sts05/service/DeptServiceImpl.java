package com.bit.sts05.service;

import java.util.List;

import com.bit.sts05.model.DeptDao;
import com.bit.sts05.model.DeptVo;

public class DeptServiceImpl implements DeptService {
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@Override
	public List<?> getList(){
		return deptDao.findAll();
	}
	
	@Override
	public void pushList(DeptVo target) {
		deptDao.seqUpdateOne();
		deptDao.insertOne(target);
	}
	
	@Override
	public DeptVo pullList(int index) {
		// 조회수 증가 dao - update
		return deptDao.findObject(index);
	}
	
	@Override
	public boolean editList(DeptVo target) {
		if(deptDao.updateOne(target)>0) return true;
		return false;
	}
	
	@Override
	public boolean removeList(int index) {
		if(deptDao.deleteOne(index)>0) return true;
		return false;
	}
}













