package com.bit.boot12.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Emp, Integer> {

	 Emp findByEname(String ename);

}
