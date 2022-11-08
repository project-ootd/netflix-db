package com.mysite.nexfilx.order.controller;

import com.mysite.nexfilx.order.dao.OrderRepository;
import com.mysite.nexfilx.order.domain.Payorder;
import com.mysite.nexfilx.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("order")
    public String setOrder(@RequestBody Payorder payorder) {
        orderService.setOrder(payorder);
        return "payorder";

    }

    @PostMapping("getorder")
    public Payorder getOrder(@RequestBody Payorder payorder) {
        Payorder findorder = orderService.findOrder(payorder);
        return findorder;

    }
}
