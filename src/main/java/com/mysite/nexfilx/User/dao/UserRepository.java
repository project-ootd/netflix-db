package com.mysite.nexfilx.User.dao;

import com.mysite.nexfilx.User.domain.User;
import com.mysite.nexfilx.User.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUseremail(String useremail);

<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> 3829c5d0c0aa8e1ee313a05338bf0ced2bfdcdab
=======
>>>>>>> 3829c5d0c0aa8e1ee313a05338bf0ced2bfdcdab
//    Optional<User> findByLastPaymentDate(String useremail);
}
