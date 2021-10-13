package com.github.mimsic.bdd.sj4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {
        "com.github.mimsic.bdd.sj4"
})
public class ApplicationLauncher {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(ApplicationLauncher.class, args);
    }
}
