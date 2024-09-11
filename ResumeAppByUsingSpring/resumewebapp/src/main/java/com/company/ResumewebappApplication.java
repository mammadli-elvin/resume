package com.company;

import com.company.repository.UserRepository;
import com.company.service.impl.UserServiceImpl;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("webapp")
public class ResumewebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumewebappApplication.class, args);
	}

}
