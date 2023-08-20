package com.sixesSense.recorder.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "\uD83C\uDF31Recorder\uD83C\uDF31",
                description = "안녕하세요 MTVS 서버반 식스센스입니다😁 \n" +
                        "\n배포링크 👉 [클릭](http://localhost:8080/)\n" +
                        "\n👀Swagger 사용 방법👀 \n" +
                        "1. 첫번째 \n" +
                        "2. 두번째 \n" +
                        "3. 세번째 \n" +
                        "\n💡설명💡",
                version = "v1"
        )
)
@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi firstOpenApi() {
        String[] paths = {
            "com.sixesSense.recorder"
        };

        return GroupedOpenApi
                .builder()
                .group("식스센스 스웨거")
                .packagesToScan(paths)
                .build();
    }

//    @Bean
//    public GroupedOpenApi secondOpenApi() {
//        String[] paths = {   };
//
//        return GroupedOpenApi
//                .builder()
//                .group("그룹이름")
//                .packagesToScan(paths)
//                .build();
//    }
}
