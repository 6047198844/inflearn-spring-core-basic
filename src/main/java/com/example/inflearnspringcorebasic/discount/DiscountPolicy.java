package com.example.inflearnspringcorebasic.discount;

import com.example.inflearnspringcorebasic.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return
     */
    int discount(Member member, int price);
}
