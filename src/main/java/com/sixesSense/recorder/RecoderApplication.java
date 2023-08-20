package com.sixesSense.recorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RecoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecoderApplication.class, args);
    }

}
