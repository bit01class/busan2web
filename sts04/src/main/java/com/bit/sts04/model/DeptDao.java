package com.bit.sts04.model;

import java.util.List;

public interface DeptDao {

	List<DeptVo> findAll();

	DeptVo findOne(int key);

	void insertOne(DeptVo bean);

	int updateOne(DeptVo bean);

	int deleteOne(int key);

}