package com.example.inflearnspringcorebasic;

import com.example.inflearnspringcorebasic.member.Grade;
import com.example.inflearnspringcorebasic.member.Member;
import com.example.inflearnspringcorebasic.member.MemberService;
import com.example.inflearnspringcorebasic.member.MemberServiceImpl;
import com.example.inflearnspringcorebasic.order.Order;
import com.example.inflearnspringcorebasic.order.OrderService;
import com.example.inflearnspringcorebasic.order.OrderServiceImpl;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        final AppConfig appConfig = new AppConfig();
//        final OrderService orderService = appConfig.orderService();
//        final MemberService memberService = appConfig.memberService();

        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        final MemberService memberService = annotationConfigApplicationContext.getBean("memberService", MemberService.class);
        final OrderService orderService = annotationConfigApplicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println(order);
    }
}
