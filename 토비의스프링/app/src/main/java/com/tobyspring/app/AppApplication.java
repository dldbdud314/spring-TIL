package com.tobyspring.app;

import com.tobyspring.app.dao.ConnectionMaker;
import com.tobyspring.app.dao.DConnectionMaker;
import com.tobyspring.app.dao.UserDao;
import com.tobyspring.app.domain.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws SQLException{

		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao dao = new UserDao(connectionMaker); //런타임 시 UserDao-ConnectionMaker 의존관계 설정

		User user = new User();
		user.setId("yylee3");
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
