package com.example.inflearnspringcorebasic;

import com.example.inflearnspringcorebasic.discount.DiscountPolicy;
import com.example.inflearnspringcorebasic.discount.FixDiscountPolicy;
import com.example.inflearnspringcorebasic.discount.RateDiscountPolicy;
import com.example.inflearnspringcorebasic.member.MemberRepository;
import com.example.inflearnspringcorebasic.member.MemberService;
import com.example.inflearnspringcorebasic.member.MemberServiceImpl;
import com.example.inflearnspringcorebasic.member.MemoryMemberRepository;
import com.example.inflearnspringcorebasic.order.OrderService;
import com.example.inflearnspringcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
