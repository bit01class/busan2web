package com.bit;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.bit.stu.LocalMySql;
import com.bit.stu.StuDao;

public class Main {

	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램(ver 0.8.0 mysql)");
		Scanner sc=new Scanner(System.in);
		String input=null;
//		String driver="com.mysql.jdbc.Driver";
//		String url="jdbc:mysql://localhost:3306/lecture";
//		Map<String,String> env=System.getenv();
//		String user=env.get("local.mysql.user");
//		String password=env.get("local.mysql.password");
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		while(true) {
			
			System.out.print("1.리스트 2.보기 3.입력 4.수정 5.삭제 0.종료>");
			input=sc.nextLine();
			if(input.equals("0")) break;
			if(input.equals("1")) {
				StuDao dao=new StuDao();
				ArrayList<int[]> list=dao.selectAll();
				for(int i=0; i<list.size(); i++) {
					System.out.printf("%d| %d| %d| %d \n"
							, list.get(i)[0], list.get(i)[1]
							, list.get(i)[2], list.get(i)[3]);
				}
			}
			if(input.equals("3")) {
				System.out.print("국어>");
				input=sc.nextLine();
				int kor=Integer.parseInt(input);
				System.out.print("영어>");
				input=sc.nextLine();
				int eng=Integer.parseInt(input);
				System.out.print("수학>");
				input=sc.nextLine();
				int math=Integer.parseInt(input);
				StuDao dao=new StuDao();
				dao.insertOne(kor,eng,math);
				
			}
		}
	}

}










