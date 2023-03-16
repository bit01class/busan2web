package com.bit.boot03.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptDao {

	@Select("select * from dept")
	List<DeptVo> findAll();
}
