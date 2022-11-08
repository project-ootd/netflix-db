package com.mysite.nexfilx.order.service;

import com.mysite.nexfilx.order.dao.OrderRepository;
import com.mysite.nexfilx.order.domain.Payorder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Payorder setOrder(Payorder payorder) {
        System.out.println("getOrderId"+payorder.getOrderId());
        System.out.println("getOrderNum"+payorder.getOrderNum());
        System.out.println("getOrderDate"+payorder.getOrderDate());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");   // yyyy-MM-dd HH:mm:ss
//        payorder.setOrderDate( formatter);
        String format = formatter.format(payorder.getOrderDate())+"-000-";
        payorder.setOrderNum(format);
        orderRepository.save(payorder);

        return payorder;
    }

    public Payorder findOrder(Payorder payorder) {
        Optional<Payorder> opPayorder = orderRepository.findByUseremail(payorder.getUseremail());
        if(opPayorder.isPresent()) {
            Payorder orderUser = opPayorder.get();
            if(orderUser.getUseremail().equals(payorder.getUseremail())){
                return orderUser;
            }
            return null;
        }
        return null;
    }
}
