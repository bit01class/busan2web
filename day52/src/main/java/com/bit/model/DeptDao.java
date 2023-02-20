package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.bit.framework.jdbc.JdbcTemplate;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DeptDao {
	String className="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/lecture";
	String user="scott";
	String password="tiger";

	JdbcTemplate template=new JdbcTemplate() {
		@Override
		public Object mapper(ResultSet rs) throws SQLException {
			DeptDto bean=new DeptDto();
			bean.setDeptno(rs.getInt("deptno"));
			bean.setDname(rs.getString("dname"));
			bean.setLoc(rs.getString("loc"));
			return bean;
		}
	};
	
	private DataSource getDataSource(){
		MysqlDataSource dataSource=new MysqlDataSource();
		dataSource.setURL(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	
	public List<DeptDto> selectAll(){
		String sql="select * from dept";
		template.setDataSource(getDataSource());
		return template.queryForAll(sql,new Object[] {});
	}
	
	public DeptDto selectOne(int deptno){
		String sql="select * from dept where deptno=?";
		template.setDataSource(getDataSource());
		return (DeptDto) template.queryForAll(sql,new Object[] {deptno}).get(0);
	}
	
	
	public int insertOne(int deptno,String dname,String loc) {
		String sql="insert into dept values (?,?,?)";
		template.setDataSource(getDataSource());
		return template.update(sql,new Object[] {deptno,dname,loc});
	}
	public int updateOne(int deptno,String dname,String loc) {
		String sql="update dept set dname=?,loc=? where deptno=?";
		Object[] objs= {dname,loc,deptno};
		template.setDataSource(getDataSource());
		return template.update(sql,objs);
			
	}
	public int deleteOne(int deptno) {
		String sql="delete from dept where deptno=?";
		template.setDataSource(getDataSource());
		return template.update(sql,new Object[] {deptno});
	}

	
	public Object setRs(ResultSet rs) throws SQLException {
		DeptDto bean=new DeptDto();
		bean.setDeptno(rs.getInt("deptno"));
		bean.setDname(rs.getString("dname"));
		bean.setLoc(rs.getString("loc"));
		return bean;
	}
}














