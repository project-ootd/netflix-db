package com.mysite.nexfilx.User.service;

import com.mysite.nexfilx.Contents.dto.NetflixDto;
import com.mysite.nexfilx.User.dao.ProfileRepository;
import com.mysite.nexfilx.User.domain.ProfileName;
import com.mysite.nexfilx.User.domain.User;
import com.mysite.nexfilx.User.dto.UserDto;
import com.mysite.nexfilx.User.dto.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileNameService {

    private final ProfileRepository profileRepository;

    public void setProfileName(User user , ProfileName profileName) {
        ProfileName profileName2 = ProfileName.builder()
                .user(user)
                .nickname(profileName.getNickname())
                .build();

        profileRepository.save(profileName2);

//        Optional<ProfileName> opProfileName = profileRepository.findByUseremail(profileName.getUseremail());
//        if (opProfileName.isPresent()) {
//            ProfileName profileName1 = opProfileName.get();
//            profileName1.setProfilename(profileName.getProfilename());
//
//            profileRepository.save(profileName1);
//        }
    }



    public UserProfileDto getProfile(User user) {
//        return profileRepository.findById(userId);
        UserProfileDto userProfileDto = new UserProfileDto(user);
        return userProfileDto;
    }




//    public User setUserName(UserDto userDto) {
//        Optional<User> opUser = userRepository.findByUseremail(userDto.getUseremail());
//        if(opUser.isPresent()) {
//            User loginedUser = opUser.get();
//
//
////            loginedUser.setUserName(userDto.getUserName());
//            loginedUser.setGameName(userDto.getGameName());
//
//
//            userRepository.save(loginedUser);
//        }
//        return null;
//    }
//
//    public User getUserName(String useremail) {
//        Optional<User> opUser = userRepository.findByUseremail(useremail);
//        User loginedUser = opUser.get();
//
//        return loginedUser;
//    }
}
