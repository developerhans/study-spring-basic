package com.hans.study.spring.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
