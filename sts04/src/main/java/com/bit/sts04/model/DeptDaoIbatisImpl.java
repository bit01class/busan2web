package com.bit.sts04.model;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DeptDaoIbatisImpl extends SqlMapClientDaoSupport implements DeptDao {

	@Override
	public List<DeptVo> findAll() {
		return getSqlMapClientTemplate().queryForList("selectAll");
	}

	@Override
	public DeptVo findOne(int key) {
		return (DeptVo) getSqlMapClientTemplate().queryForObject("selectOne",key);
	}

	@Override
	public void insertOne(DeptVo bean) {

	}

	@Override
	public int updateOne(DeptVo bean) {
		return getSqlMapClientTemplate().update("updateOne",bean);
	}

	@Override
	public int deleteOne(int key) {
		return getSqlMapClientTemplate().delete("deleteOne",key);
	}

}
