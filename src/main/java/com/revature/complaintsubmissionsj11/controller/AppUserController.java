package com.revature.complaintsubmissionapplication.controller;

import com.revature.complaintsubmissionapplication.dto.AppUserReturnInfo;
import com.revature.complaintsubmissionapplication.entity.AppUser;
import com.revature.complaintsubmissionapplication.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @PostMapping()
    public AppUserReturnInfo insert(@RequestBody AppUser appUser){
        AppUser returnedUser = appUserService.insert(appUser);
        return new AppUserReturnInfo(returnedUser);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<AppUserReturnInfo> getAll(@RequestParam(required = false, value = "role") String flag){
        if (flag == null){
            List<AppUser> allReturned =  appUserService.getAll();
            List<AppUserReturnInfo> privateAllReturn = new ArrayList<>();
            int listLength = allReturned.size()-1;
            while (listLength>=0){
                privateAllReturn.add(new AppUserReturnInfo(allReturned.get(listLength)));
                listLength--;
            }
            return privateAllReturn;
        }
        else {
            List<AppUser> allReturned =  appUserService.getAll(flag);
            List<AppUserReturnInfo> privateAllReturn = new ArrayList<>();
            int listLength = allReturned.size()-1;
            while (listLength>=0){
                privateAllReturn.add(new AppUserReturnInfo(allReturned.get(listLength)));
                listLength--;
            }
            return privateAllReturn;
        }
    }

    @GetMapping("/{userIdentifier}")
    public AppUserReturnInfo getByIdOrUsername(@PathVariable("userIdentifier") String identifier){
        try{
            Long id = Long.parseLong(identifier);
            AppUser returnedUser = appUserService.getById(id);
            return new AppUserReturnInfo(returnedUser);
        }
        catch (Exception e){
            AppUser returnedUser = appUserService.getByUsername(identifier);
            return new AppUserReturnInfo(returnedUser);
        }
    }

    @PutMapping()
    public AppUserReturnInfo update(@RequestBody AppUser appUser){
        AppUser returnedUser = appUserService.update(appUser);
        return new AppUserReturnInfo(returnedUser);
    }

    @DeleteMapping("/{userId}")
    public boolean delete(@PathVariable("userId") Long userId){
        return appUserService.delete(userId);
    }




}
