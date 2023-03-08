package com.bit.sts06.model;

import java.util.List;

public interface DeptDao {

	List<DeptVo> findAll();

	DeptVo findObject(int key);

	void insertOne(DeptVo bean);

	int updateOne(DeptVo bean);

	int deleteOne(int key);

}