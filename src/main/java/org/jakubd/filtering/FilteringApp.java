package org.jakubd.filtering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.jakubd.filtering")
@EnableJpaRepositories
public class FilteringApp {

    public static void main(String[] args) {
        SpringApplication.run(FilteringApp.class);
    }
}
