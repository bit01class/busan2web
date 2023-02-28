package com.bit.sts02.model;

import java.util.List;

public interface DeptDao {
	List<DeptVo> findAll();

	void insertOne(DeptVo bean);
	
	DeptVo findOne(int deptno);
	
	int updateOne(DeptVo bean);
	
	int deleteOne(int deptno);
}














