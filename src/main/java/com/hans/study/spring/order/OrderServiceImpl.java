package com.hans.study.spring.order;

import com.hans.study.spring.discount.DiscountPolicy;
import com.hans.study.spring.discount.FixDiscountPolicy;
import com.hans.study.spring.member.Member;
import com.hans.study.spring.member.MemberRepository;
import com.hans.study.spring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
