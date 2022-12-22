package com.mysite.nexfilx.User.dto;

import com.mysite.nexfilx.Contents.dto.NetflixDetailDto;
import com.mysite.nexfilx.User.domain.ProfileName;
import com.mysite.nexfilx.User.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String password;
    private String useremail;

    private Date nowdate;

    private Date lastPaymentDate;



    private List<ProfileNameDto> profileNameListDto;


//    public UserDto(User user) {
//        id = user.getId();
//        password = user.getPassword();
//        auth = user.getAuth();
//        lastPaymentDate = user.getLastPaymentDate();
//        useremail = user.getUseremail();
//        profileNameListDto = new ArrayList<>();
//        user.getProfileNameList().stream()
//                .forEach(profileName -> {
//                    ProfileNameDto profileNameDto = new ProfileNameDto(profileName);
//                    profileNameListDto.add(profileNameDto);
//                });
//    }

//
////        userName = user.getUseremail();
//
////        userName = new ArrayList<>();
////        user.getUserName().stream()
////                .forEach(profileName -> {
////                    ProfileNameDto profileNameDto = new ProfileNameDto(profileName);
////                    userName.add(profileNameDto);
////                });
//
//
//    }


}
