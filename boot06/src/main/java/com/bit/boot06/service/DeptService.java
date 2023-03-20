package com.bit.boot06.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bit.boot06.domain.DeptRepo;
import com.bit.boot06.domain.RequestDeptVo;
import com.bit.boot06.domain.ResponseDeptVo;
import com.bit.boot06.domain.entity.Dept03;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeptService {
	private final DeptRepo deptRepo;

	ResponseDeptVo insertOne(RequestDeptVo bean) {
		
		Dept03 entity=Dept03.builder()
				.deptno(bean.getDeptno())
				.dname(bean.getDname())
				.loc(bean.getLoc())
				.build();
		return deptRepo.save(entity).getEntity();
	}
	
	ResponseDeptVo selectOne(int deptno) {
		return deptRepo.findById((long)deptno).get().getEntity();
//		return deptRepo.findByDnameContaining("2").get().getEntity();
	}
	
	ResponseDeptVo updateOne(RequestDeptVo bean) {
		Optional<Dept03> op=deptRepo.findById(bean.getDeptno());
		if(op.isEmpty()) throw new RuntimeException("존재하지 않음");
		return deptRepo.save(Dept03.builder()
				.deptno(op.get().getDeptno())	// 안바꿈
				.dname(bean.getDname())			// 바꿈
				.loc(bean.getLoc())				// 바꿈
				.build()).getEntity();
	}
	
	void deleteOne(long deptno) {
		Optional<Dept03> op=deptRepo.findById(deptno);
		if(op.isEmpty()) throw new RuntimeException("존재하지 않음");
//		deptRepo.deleteById(deptno);
		deptRepo.delete(op.get());
	}
	
	List<ResponseDeptVo> selectAll(){
		List<ResponseDeptVo> list=new ArrayList<>();
//		deptRepo.myall().forEach(bean->list.add(bean.getEntity()));
//		deptRepo.findAll(PageRequest.of(0, 2)).forEach(bean->list.add(bean.getEntity()));
//		deptRepo.findAll(Pageable.ofSize(2).withPage(0)).forEach(bean->list.add(bean.getEntity()));
//		deptRepo.findAll(Sort.by("deptno").descending()).forEach(bean->list.add(bean.getEntity()));
//		deptRepo.findAllByOrderByDeptnoDesc().forEach(bean->list.add(bean.getEntity()));
//		for(Dept03 bean : deptRepo.findAll())
		Sort sort=Sort.by("deptno").descending();
		for(Dept03 bean : deptRepo.myall(5555))
			list.add(ResponseDeptVo.builder()
					.deptno(bean.getDeptno())
					.dname(bean.getDname())
					.loc(bean.getLoc())
					.build());
		return list;
	}
	
	List<ResponseDeptVo> selectAll(int pageNum,int limit){
		List<ResponseDeptVo> list=new ArrayList<>();
//		Sort sort=Sort.by("deptno").descending();
//		Pageable page=PageRequest.of(pageNum, limit,Sort.by("deptno").descending());
		Pageable page=Pageable.ofSize(limit).withPage(pageNum);
		deptRepo.findAll(page).forEach(ele->list.add(ele.getEntity()));
		return list;
	}
}









