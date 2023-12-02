package com.loginManagement.service;

import com.loginManagement.model.Login;
import com.loginManagement.repo.LoginRepository;
import com.loginManagement.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    LoginRepository loginRepo;

    @Autowired
    UserRepository userRepo;



    public boolean loginEvent( Login login) {
        Login foundUser = userRepo.findByNameAndPassword(login.getName(), login.getPassword());

        if (foundUser != null) {
            return true;
        } else {

            return false;
        }

    }




}
