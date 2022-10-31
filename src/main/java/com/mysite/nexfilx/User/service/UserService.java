package com.mysite.nexfilx.User.service;

import com.mysite.nexfilx.User.dao.UserRepository;
import com.mysite.nexfilx.User.domain.User;
import com.mysite.nexfilx.User.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User join(User user) {
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

    }


