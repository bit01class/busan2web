package com.bit.sts06.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDaoMyImpl implements DeptDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<DeptVo> findAll() {
		return sqlSession.selectList("dept.selectAll");
	}

	@Override
	public DeptVo findObject(int key) {
		return sqlSession.selectOne("dept.selectOne", key);
	}

	@Override
	public void insertOne(DeptVo bean) {
		sqlSession.insert("dept.insertOne",bean);
	}

	@Override
	public int updateOne(DeptVo bean) {
		return sqlSession.update("dept.updateOne",bean);
	}

	@Override
	public int deleteOne(int key) {
		return sqlSession.delete("dept.deleteOne",key);
	}

}
