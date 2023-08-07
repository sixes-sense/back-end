package com.sixthsense.recoder.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.goalapa.cacamuca")
@EnableJpaRepositories(basePackages = "com.sixthsense.recoder")
public class JpaConfiguration {
}
