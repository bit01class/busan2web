package com.bit.boot03.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class DeptVo {

	private int deptno;
	private String dname;
	private String loc;
}
