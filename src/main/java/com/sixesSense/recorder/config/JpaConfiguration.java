package com.sixesSense.recorder.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.sixesSense.recorder")
@EnableJpaRepositories(basePackages = "com.sixesSense.recorder")
public class JpaConfiguration {
}
