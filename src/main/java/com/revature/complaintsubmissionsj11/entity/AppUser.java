package com.revature.complaintsubmissionsj11.entity;

import com.revature.complaintsubmissionsj11.dto.AppUserReturnInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class AppUser extends AppUserReturnInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String fullName;
    private String username;
    private String password;
    private String role;
    private String aboutMe;
    private String imgLink;


    public AppUser(String fullName, String username, String password, String role, String aboutMe, String imgLink){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.aboutMe = aboutMe;
        this.imgLink = imgLink;

    }


}


