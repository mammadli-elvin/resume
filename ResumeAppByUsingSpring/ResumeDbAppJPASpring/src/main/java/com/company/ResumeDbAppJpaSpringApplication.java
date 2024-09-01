package com.company;

import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class ResumeDbAppJpaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
    }

    @Autowired
    UserServiceInter userService;

    @Bean
    public CommandLineRunner run() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                userService.getUsersByCategory(null, null, null);
                System.out.println(userService.getUserById(6));
            }
        };
    }
}
