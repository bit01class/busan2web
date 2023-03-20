package com.bit.boot06.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bit.boot06.domain.ResponseDeptVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "dept03")
public class Dept03 {
	@Id													// pk
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private long deptno;

	
//	@Column(name = "domainname",columnDefinition = "varchar(8) default '제목없음'",nullable = false)
	@Column(columnDefinition = "varchar(8)")
	private String dname;
//	@Column(name = "location",columnDefinition = "text not null")
	private String loc;
	
	
	public ResponseDeptVo getEntity() {
		return ResponseDeptVo
				.builder()
				.deptno(deptno)
				.dname(dname)
				.loc(loc)
				.build();
	}
}









