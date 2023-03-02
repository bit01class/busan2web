package com.bit.spring.model;

import java.util.List;

public interface DeptDao {
	List<DeptVo> findAll();
	DeptVo findOne(int rownum);
	void insertOne(DeptVo bean);
	int updateOne(DeptVo bean);
	int deleteOne(int rownum);
}

