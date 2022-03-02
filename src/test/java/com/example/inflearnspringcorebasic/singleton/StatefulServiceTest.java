package com.example.inflearnspringcorebasic.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        final StatefulService statefulService1 = ac.getBean(StatefulService.class);
        final StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자 10000원 주문
        statefulService1.order("userA", 10000);
        statefulService1.order("userB", 20000);

        final int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}