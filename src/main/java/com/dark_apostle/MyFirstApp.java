package com.dark_apostle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@springbootapplication注解被视作三合一
@SpringBootApplication
public class MyFirstApp {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstApp.class,args);
    }

}
