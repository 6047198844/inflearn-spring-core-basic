package com.example.inflearnspringcorebasic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.example.inflearnspringcorebasic.member",
        basePackageClasses = AutoAppConfig.class, // com.example.inflearnspringcorebasic 패키지로 바뀐다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION ,classes = Configuration.class)
)
public class AutoAppConfig {

}
