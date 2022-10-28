package com.mysite.nexfilx.User.controller;

import com.mysite.nexfilx.User.domain.User;
import com.mysite.nexfilx.User.dto.UserDto;
import com.mysite.nexfilx.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("")
    public String test() {
        return "test";
    }

    @PostMapping("/join")
    public String setUser(@RequestBody User user) {
        user.setUseremail(user.getUseremail());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setPassword(user.getPassword());

        userService.join(user.getUseremail(), user.getPassword());


        return "회원가입 완료";
    }

//    @PostMapping("/login")
//    public String login() {
//        return "로그인 완료";
//    }

    @PostMapping("/login")
    public UserDto login(@RequestBody User user) throws Exception {
        UserDto loginedUser = userService.login(user);
        return loginedUser;
    }



}
