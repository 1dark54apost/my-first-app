package com.dark_apostle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.FilterOutputStream;

//@springbootapplication注解被视作三合一
@SpringBootApplication
public class MyFirstApp {

    @Autowired
    private Environment environment;

    private void decode(){
        environment.getActiveProfiles();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyFirstApp.class,args);
    }

}
