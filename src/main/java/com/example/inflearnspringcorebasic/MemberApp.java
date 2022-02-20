package com.example.inflearnspringcorebasic;

import com.example.inflearnspringcorebasic.member.Grade;
import com.example.inflearnspringcorebasic.member.Member;
import com.example.inflearnspringcorebasic.member.MemberService;
import com.example.inflearnspringcorebasic.member.MemberServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        final MemberService memberService = appConfig.memberService();
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        final MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        final Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        final Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
