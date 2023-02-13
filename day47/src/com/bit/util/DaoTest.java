package com.bit.util;

import java.sql.SQLException;
import java.util.List;

import com.bit.model.EmpDao;
import com.bit.model.EmpDto;

public class DaoTest {
	static EmpDto target=new EmpDto();
	static EmpDao dao=new EmpDao();

	public static void main(String[] args) throws SQLException {
		target.setEmpno(8888);
		target.setEname("user8");
		target.setSal(1000);
		getListTest();
		pushListTest();
		getOneTest();
		editOneTest();
		getOneTest();
		deleteOneTest();
		try {
		getOneTest();
		}catch(Exception e) {
			System.out.println("성공");
		}
	}
	public static void deleteOneTest() throws SQLException {
		System.out.println(dao.deleteOne(target.getEmpno())>0);
	}
	
	public static void editOneTest() throws SQLException {
		target.setEname("user8");
		System.out.println(dao.editOne(target.getEmpno(),target.getEname()
				,target.getComm(),target.getSal(), target.getMgr())>0);
	}
	
	public static void getOneTest() throws SQLException {
		EmpDto bean=dao.getOne(target.getEmpno());
		System.out.println(bean!=null);
		System.out.println(bean.getEname().equals(target.getEname()));
	}
	
	public static void pushListTest() throws SQLException {
		System.out.println(dao.pushList(target.getEmpno()
						,target.getEname(),target.getSal())>0);
	}
	
	public static void getListTest() throws SQLException {
		List<EmpDto> list=dao.getList();
		System.out.println(list!=null);
		System.out.println(list.size()>0);		
	}

}




