package com.revature.complaintsubmissionapplication.controller;

import com.revature.complaintsubmissionapplication.dto.AppUserReturnInfo;
import com.revature.complaintsubmissionapplication.dto.LoginForm;
import com.revature.complaintsubmissionapplication.entity.AppUser;
import com.revature.complaintsubmissionapplication.exceptions.UserNotFoundException;
import com.revature.complaintsubmissionapplication.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
