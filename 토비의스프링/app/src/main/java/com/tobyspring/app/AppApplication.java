package com.tobyspring.app;

import com.tobyspring.app.dao.DaoFactory;
import com.tobyspring.app.dao.UserDao;
import com.tobyspring.app.domain.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws SQLException{

		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

		UserDao dao = context.getBean("userDao", UserDao.class); //생성 방법 결정 및 생성

		User user = new User();
		user.setId("yylee5");
		user.setName("유영");
		user.setPassword("1234");

		dao.add(user);

		System.out.println(user.getId() + " 등록 성공");

		User user2 = dao.get(user.getId());

		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user2.getId() + " 조회 성공");
	}

}
