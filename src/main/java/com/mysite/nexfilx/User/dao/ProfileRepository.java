package com.mysite.nexfilx.User.dao;

import com.mysite.nexfilx.User.domain.ProfileName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileName, Long> {


//    List<ProfileName> findByUseremail(String userId);
}
