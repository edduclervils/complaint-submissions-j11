package com.revature.complaintsubmissionapplication.dto;

import com.revature.complaintsubmissionapplication.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data@NoArgsConstructor@AllArgsConstructor
public class AppUserReturnInfo {
    private Long userId;
    private String fullName;
    private String username;
    private String role;
    private String aboutMe;
    private String imgLink;



    public AppUserReturnInfo(AppUser appUser) {
        this.userId = appUser.getUserId();
        this.fullName = appUser.getFullName();
        this.username = appUser.getUsername();
        this.role = appUser.getRole();
        this.aboutMe = appUser.getAboutMe();
        this.imgLink = appUser.getImgLink();
    }

}
