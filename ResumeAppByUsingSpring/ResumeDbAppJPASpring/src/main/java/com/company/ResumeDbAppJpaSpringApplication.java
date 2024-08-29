package com.company;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResumeDbAppJpaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
	}

	@Autowired
	@Qualifier("userDao1")
	UserDaoInter userDao;

	@Bean
	public CommandLineRunner run() {
        return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<User> list = userDao.getAllUsers();
				System.out.println(list);
			}
		};
	}

}
