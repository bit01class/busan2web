package com.bit.sts05.model;

import java.util.List;

public interface DeptDao {

	List<DeptVo> findAll();
	DeptVo	findObject(int pk);
	void seqUpdateOne();
	void insertOne(DeptVo bean);
	int updateOne(DeptVo bean);
	int deleteOne(int pk);
}
