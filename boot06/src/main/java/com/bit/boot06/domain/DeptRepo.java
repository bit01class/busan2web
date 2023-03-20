package com.bit.boot06.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bit.boot06.domain.entity.Dept03;

public interface DeptRepo extends JpaRepository<Dept03, Long> {

	Iterable<Dept03> findAllByOrderByDnameDesc();
	Iterable<Dept03> findAllByOrderByDeptnoDesc();
	Optional<Dept03> findByDname(String dname);
	Optional<Dept03> findByDnameContaining(String dname);
	
//	List<Dept03> findAll(Sort sort);
	@Query(value = "select x.deptno,x.dname,x.loc from dept03 x where x.deptno < :su",nativeQuery = true)
	List<Dept03> myall(long su);
	

}
