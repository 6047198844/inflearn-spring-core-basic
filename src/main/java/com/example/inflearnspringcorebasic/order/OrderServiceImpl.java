package com.example.inflearnspringcorebasic.order;

import com.example.inflearnspringcorebasic.discount.DiscountPolicy;
import com.example.inflearnspringcorebasic.discount.FixDiscountPolicy;
import com.example.inflearnspringcorebasic.discount.RateDiscountPolicy;
import com.example.inflearnspringcorebasic.member.Member;
import com.example.inflearnspringcorebasic.member.MemberRepository;
import com.example.inflearnspringcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        final Member member = memberRepository.findById(memberId);
        final int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
