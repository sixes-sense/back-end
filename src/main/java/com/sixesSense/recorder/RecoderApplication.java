package com.sixesSense.recorder;

import com.sixesSense.recorder.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(MyConfig.class)
@EnableJpaAuditing
public class RecoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecoderApplication.class, args);
    }

}
