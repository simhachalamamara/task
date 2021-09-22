package com.example.productauthorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
@EnableResourceServer
public class ProductAuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductAuthorizationServerApplication.class, args);
    }
    @GetMapping("/validateToekn")
    public Principal validTokens(Principal user)
    {
        return user;
    }
    @GetMapping("/hello")
    public String getHello()
    {
        System.out.println("hello");
        return "hello";
    }
}
