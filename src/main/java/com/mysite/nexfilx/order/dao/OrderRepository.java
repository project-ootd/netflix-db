package com.mysite.nexfilx.order.dao;

import com.mysite.nexfilx.User.domain.User;
import com.mysite.nexfilx.order.domain.Payorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository  extends JpaRepository<Payorder, Long>{

    Optional<Payorder> findByUseremail(String useremail);

    List<Payorder> findAllByUseremail(String useremail);
}
