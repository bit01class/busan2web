package com.bit.sts06.service;

import java.util.List;

import com.bit.sts06.model.DeptVo;

public interface DeptService {

	List<DeptVo> selectAll();

	void insertOne(DeptVo bean);

	DeptVo selectOne(int deptno);

	int updateOne(DeptVo bean);

	int deleteOne(int deptno);

}