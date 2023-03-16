package com.bit.boot03;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bit.boot03.model.DeptDao;

@SpringBootApplication
@MapperScan(basePackageClasses = DeptDao.class)
public class Boot03Application {
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(Boot03Application.class, args);
	}
	
	@Bean
	public SqlSessionFactory getSqlSessionfFactory() throws Exception {
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();
	}

}
