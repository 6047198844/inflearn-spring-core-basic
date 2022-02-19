package com.example.inflearnspringcorebasic;

import com.example.inflearnspringcorebasic.member.Grade;
import com.example.inflearnspringcorebasic.member.Member;
import com.example.inflearnspringcorebasic.member.MemberService;
import com.example.inflearnspringcorebasic.member.MemberServiceImpl;
import com.example.inflearnspringcorebasic.order.Order;
import com.example.inflearnspringcorebasic.order.OrderServiceImpl;
import com.sun.tools.corba.se.idl.constExpr.Or;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        final OrderServiceImpl orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println(order);
    }
}
