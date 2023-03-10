package com.bit.boot02.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bit.boot02.model.entity.DeptVo;

@Mapper
public interface DeptDao {

	@Select("select * from dept")
	List<DeptVo> findAll();

	@Insert("insert into dept values (#{deptno},#{dname},#{loc})")
	void insertOne(DeptVo bean);

	@Select("select * from dept where deptno=#{idx}")
	DeptVo findOne(int idx);
}
