package hkAiRpaProject;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class DataBaseInfo {
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource, 
			ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(
				applicationContext.getResources("classpath:mappers/**/*Mapper.xml")
				);
		sessionFactory.setTypeAliasesPackage("hkAiRpaProject.domain");
		return sessionFactory.getObject();
	}
}
