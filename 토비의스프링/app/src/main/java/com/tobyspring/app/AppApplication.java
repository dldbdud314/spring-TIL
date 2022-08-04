package com.tobyspring.app;

import com.tobyspring.app.dao.UserDao;
import com.tobyspring.app.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		UserDao dao = new UserDao();

		User user = new User();
		user.setId("yylee");
		user.setName("유영");
		user.setPassword("1234");

		dao.add(user);

		System.out.println(user.getId() + " 등록 성공");

		User user2 = dao.get(user.getId());

		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user2.getId() + " 조회 성공");

		//SpringApplication.run(AppApplication.class, args);
	}

}
