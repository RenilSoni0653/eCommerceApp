package com.humber.imageservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "E-Commerce App", version = "1.0", description= "E-Commerce App"))
public class ImageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageServiceApplication.class, args);
    }

}
