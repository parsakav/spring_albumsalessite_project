package com.springproject.albumproject;

import com.springproject.albumproject.controller.SignupController;
import com.springproject.albumproject.model.Role;
import com.springproject.albumproject.model.User;
import com.springproject.albumproject.repository.RoleRepository;
import com.springproject.albumproject.repository.UserRepository;
import com.springproject.albumproject.service.RoleService;
import com.springproject.albumproject.service.RoleServiceImpl;
import com.springproject.albumproject.service.UserService;
import com.springproject.albumproject.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AlbumProjectApplication extends SpringBootServletInitializer  {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AlbumProjectApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(AlbumProjectApplication.class, args);

    }


  /*  @Bean
    CommandLineRunner initDatabase(RoleRepository roleService) {
        return args -> {
            Role role = new Role();
            role.setName("ROLE_USER");
            roleService.save(role);
            role.setId(SignupController.Roles.ROLE_ADMIN);
            role.setName(SignupController.Roles.ROLE_2);
            roleService.save(role);

        };
    }*/
}
