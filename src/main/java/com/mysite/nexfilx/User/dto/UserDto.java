package com.mysite.nexfilx.User.dto;

import com.mysite.nexfilx.Contents.dto.NetflixDetailDto;
import com.mysite.nexfilx.User.domain.ProfileName;
import com.mysite.nexfilx.User.domain.User;
import lombok.*;
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
@Getter
@Setter
public class UserDto {
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 3829c5d0c0aa8e1ee313a05338bf0ced2bfdcdab
=======

>>>>>>> 3829c5d0c0aa8e1ee313a05338bf0ced2bfdcdab
    private String useremail;
    private String  nowdate;
    private String lastPaymentDate;


<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 3829c5d0c0aa8e1ee313a05338bf0ced2bfdcdab
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nowdate;

    private Date lastPaymentDate;


<<<<<<< HEAD
>>>>>>> 3829c5d0c0aa8e1ee313a05338bf0ced2bfdcdab
=======
>>>>>>> 3829c5d0c0aa8e1ee313a05338bf0ced2bfdcdab

}
