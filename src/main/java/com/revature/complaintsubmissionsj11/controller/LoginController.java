package com.revature.complaintsubmissionsj11.controller;

import com.revature.complaintsubmissionsj11.dto.AppUserReturnInfo;
import com.revature.complaintsubmissionsj11.dto.LoginForm;
import com.revature.complaintsubmissionsj11.entity.AppUser;
import com.revature.complaintsubmissionsj11.exceptions.UserNotFoundException;
import com.revature.complaintsubmissionsj11.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    AppUserService appUserService;

    Logger logger1 = LoggerFactory.getLogger(LoginController.class);

    @PatchMapping()
    public ResponseEntity<AppUserReturnInfo> verifyUser(@RequestBody LoginForm loginForm) throws UserNotFoundException {
        logger1.info("Verifying Login");

        AppUser returnedUser = appUserService.verify(loginForm);
        return new ResponseEntity<>(new AppUserReturnInfo(returnedUser), HttpStatus.OK);
    }
}
