package com.org;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringJDBCConfiguration {
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    //MySQL database we are using
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/login");//change url
    dataSource.setUsername("root");//change userid
    dataSource.setPassword("root@_123");//change pwd
    return dataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource());
    return jdbcTemplate;
  }

  @Bean
  public EmployeeDAO employeeDAO(){
    EmployeeDAOImpl empDao = new EmployeeDAOImpl();
    empDao.setJdbcTemplate(jdbcTemplate());
    return empDao;
  }

}

