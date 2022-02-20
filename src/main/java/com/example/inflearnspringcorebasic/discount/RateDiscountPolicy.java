package com.example.inflearnspringcorebasic.discount;

import com.example.inflearnspringcorebasic.member.Grade;
import com.example.inflearnspringcorebasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private final static int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
