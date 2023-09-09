package com.teameanrique.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabases {
    
    @Bean
    public CommandLineRunner initDatabase(PublisherRepository repository) {
        return args -> {
            repository.save(new Publisher("Parker Brothers"));
            repository.save(new Publisher("Mattel"));
            repository.save(new Publisher("Hansbro"));
            repository.save(new Publisher("Kosmos"));
        };
    }
}
