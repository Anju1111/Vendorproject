package com.ust.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ust.model.Login;

public class LoginDao {

	// Establishing connection with the database

		
		JdbcTemplate template;
		public void setTemplate(JdbcTemplate template)
		{
			this.template=template;
		}

	// To authenticate the user

		public Login LoginAuth(String userName, String password) {
			Login login = new Login();

			String sql = "select userId,userName,password from ust_loginTable where userName = ? and password = ?";

			try {
				login = (Login) template.queryForObject(sql, new Object[] {
						userName, password }, new BeanPropertyRowMapper<Login>(
						Login.class));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return login;
		}
	}

}
