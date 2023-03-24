package com.revature.complaintsubmissionapplication.service;


import com.revature.complaintsubmissionapplication.dto.LoginForm;
import com.revature.complaintsubmissionapplication.entity.AppUser;
import com.revature.complaintsubmissionapplication.exceptions.UserNotFoundException;
import com.revature.complaintsubmissionapplication.repository.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    AppUserRepository appUserRepository;

    Logger logger1 = LoggerFactory.getLogger(AppUserServiceImpl.class);

    @Override
    public AppUser insert(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser getById(Long userId) {
        return appUserRepository.findById(userId).get();
    }

    @Override
    public AppUser getByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser update(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public boolean delete(Long userId) {
        boolean found = appUserRepository.existsById(userId);
        if (found) appUserRepository.deleteById(userId);
        return found;
    }

    @Override
    public List<AppUser> getAll(String flag) {
        if (flag == null){
            return appUserRepository.findAll();
        }
        else{
            return appUserRepository.findByRole(flag);
        }
    }

    @Override
    public AppUser verify(LoginForm loginForm) throws UserNotFoundException {
        AppUser returnedUser = appUserRepository.verifyLogin(loginForm.getUsername(), loginForm.getPassword());
        if(returnedUser == null) throw new UserNotFoundException();
        logger1.info("Login Successful");
        return returnedUser;
    }

}
