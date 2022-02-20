package com.example.inflearnspringcorebasic.order;

import com.example.inflearnspringcorebasic.discount.DiscountPolicy;
import com.example.inflearnspringcorebasic.discount.FixDiscountPolicy;
import com.example.inflearnspringcorebasic.discount.RateDiscountPolicy;
import com.example.inflearnspringcorebasic.member.Member;
import com.example.inflearnspringcorebasic.member.MemberRepository;
import com.example.inflearnspringcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        final Member member = memberRepository.findById(memberId);
        final int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
