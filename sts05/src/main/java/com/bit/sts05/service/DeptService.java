package com.bit.sts05.service;

import java.util.List;

import com.bit.sts05.model.DeptVo;

public interface DeptService {

	List<?> getList();

	void pushList(DeptVo target);

	DeptVo pullList(int index);

	boolean editList(DeptVo target);

	boolean removeList(int index);

}