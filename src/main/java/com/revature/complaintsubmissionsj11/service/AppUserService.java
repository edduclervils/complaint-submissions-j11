package com.revature.complaintsubmissionsj11.service;

import com.revature.complaintsubmissionsj11.dto.LoginForm;
import com.revature.complaintsubmissionsj11.entity.AppUser;
import com.revature.complaintsubmissionsj11.exceptions.UserNotFoundException;

import java.util.List;

public interface AppUserService {
    AppUser insert(AppUser appUser);
    AppUser getById(Long userId);
    AppUser getByUsername(String username);
    List<AppUser> getAll();
    AppUser update(AppUser appUser);
    boolean delete (Long userId);
    List<AppUser> getAll(String flag);
    AppUser verify(LoginForm loginForm) throws UserNotFoundException;

}
