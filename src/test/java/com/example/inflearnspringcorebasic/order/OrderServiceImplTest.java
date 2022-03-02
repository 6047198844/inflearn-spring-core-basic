package com.example.inflearnspringcorebasic.order;

import com.example.inflearnspringcorebasic.discount.RateDiscountPolicy;
import com.example.inflearnspringcorebasic.member.Grade;
import com.example.inflearnspringcorebasic.member.Member;
import com.example.inflearnspringcorebasic.member.MemberRepository;
import com.example.inflearnspringcorebasic.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        final MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        final OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
        final Order order = orderService.createOrder(1L, "itemA", 160000);
        assertThat(order.getDiscountPrice()).isEqualTo(16000);
    }
}