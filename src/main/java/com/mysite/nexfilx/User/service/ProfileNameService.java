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

    }



    public UserProfileDto getProfile(User user) {
//        return profileRepository.findById(userId);
        UserProfileDto userProfileDto = new UserProfileDto(user);
        return userProfileDto;
    }

    public void updateProfile(User user, ProfileName profileName) {
//        profileRepository.delete(ProfileName.builder()
//                        .id(profileName.getId())
//                .build());
         profileRepository.save(ProfileName.builder()
                 .id(profileName.getId())
                 .user(user)
                 .nickname(profileName.getNickname())
                 .build());
    }

    public void deleteProfile(ProfileName profileName) {
        profileRepository.delete(ProfileName.builder()
                .id(profileName.getId())
                .build());
    }
}
