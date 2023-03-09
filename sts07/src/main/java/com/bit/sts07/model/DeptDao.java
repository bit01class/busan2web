package com.bit.sts07.model;

import java.util.List;

import com.bit.sts07.model.entity.DeptVo;

public interface DeptDao {

	List<DeptVo> findAll();
	DeptVo findOne(int pk);
	void insertOne(DeptVo bean);
	int updateOne(DeptVo bean);
	int deleteOne(int pk);
}
