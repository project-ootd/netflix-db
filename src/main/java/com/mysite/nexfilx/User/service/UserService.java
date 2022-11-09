package com.mysite.nexfilx.User.service;

import com.mysite.nexfilx.User.dao.UserRepository;
import com.mysite.nexfilx.User.domain.User;
import com.mysite.nexfilx.order.domain.Payorder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User join(User user) {

//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   // yyyy-MM-dd HH:mm:ss
//        String format = formatter.format(LocalDate.now());
//        Date date = java.sql.Timestamp.valueOf(LocalDateTime.now());
//
//        user.setLastPaymentDate(date);
        user.setAuth(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));


        userRepository.save(user);
        return user;

    }

    public User login(User user) {
        Optional<User> opUser = userRepository.findByUseremail(user.getUseremail());
        if(opUser.isPresent()) {
            User loginedUser = opUser.get();

            if(passwordEncoder.matches(user.getPassword(), loginedUser.getPassword())){
                return loginedUser;
            }
            return null;
        }
        return null;
    }

    public User setOrder(Payorder payorder) {
        Optional<User> opUser = userRepository.findByUseremail(payorder.getUseremail());
        if(opUser.isPresent()) {
            User orderUser = opUser.get();

            orderUser.setAuth(!orderUser.getAuth());
            orderUser.setLastPaymentDate(payorder.getOrderDate());
            userRepository.save(orderUser);
        }
        return null;
    }
}


