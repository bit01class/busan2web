package com.bit.sts07.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts07.model.DeptDao;
import com.bit.sts07.model.entity.DeptVo;

@Service
@Transactional
public class DeptService {
	@Autowired
	SqlSession sqlSession;
	
	public List<DeptVo> selectAll(){
		return sqlSession.getMapper(DeptDao.class).findAll(); 
	}
	
	public DeptVo selectOne(int deptno) {
		return sqlSession.getMapper(DeptDao.class).findOne(deptno);
	}
	
	public void insertOne(DeptVo bean) {
		sqlSession.getMapper(DeptDao.class).insertOne(bean);
	}
	
	public int updateOne(DeptVo bean) {
		return sqlSession.getMapper(DeptDao.class).updateOne(bean);
	}

	public int deleteOne(int deptno) {
		return sqlSession.getMapper(DeptDao.class).deleteOne(deptno);
	}
}













