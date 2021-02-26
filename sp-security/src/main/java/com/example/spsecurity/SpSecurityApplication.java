package com.example.spsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpSecurityApplication {

    @GetMapping("/{word}")
    public String encrypt(@PathVariable String word, BCryptPasswordEncoder encoder) {
        return new BCryptPasswordEncoder().encode(word);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpSecurityApplication.class, args);
    }
}
