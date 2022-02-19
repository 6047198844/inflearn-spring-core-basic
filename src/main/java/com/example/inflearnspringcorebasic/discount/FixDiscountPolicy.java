package com.example.inflearnspringcorebasic.discount;

import com.example.inflearnspringcorebasic.member.Grade;
import com.example.inflearnspringcorebasic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private static final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
