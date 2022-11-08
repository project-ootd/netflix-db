package com.mysite.nexfilx.order.dao;

import com.mysite.nexfilx.User.domain.User;
import com.mysite.nexfilx.order.domain.Payorder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository  extends JpaRepository<Payorder, Long> {
    Optional<Payorder> findByUseremail(String useremail);
}
