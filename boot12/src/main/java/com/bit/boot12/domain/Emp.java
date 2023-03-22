package com.bit.boot12.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.boot12.model.EmpVo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
public class Emp{
	@Id
	private int empno;
	private int mgr;
	private String ename,job;
	private LocalDate hiredate;
	
	public EmpVo getEntity() {
		return EmpVo.builder()
				.empno(empno).ename(ename).mgr(mgr).job(job).hiredate(hiredate)
				.build();
	}
}







