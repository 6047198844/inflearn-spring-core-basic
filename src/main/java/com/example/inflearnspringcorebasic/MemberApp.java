package com.example.inflearnspringcorebasic;

import com.example.inflearnspringcorebasic.member.Grade;
import com.example.inflearnspringcorebasic.member.Member;
import com.example.inflearnspringcorebasic.member.MemberService;
import com.example.inflearnspringcorebasic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        final Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        final Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
