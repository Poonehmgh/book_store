package com.bookz.store.service;

import com.bookz.store.repo.UserRepo;
import com.bookz.store.model.Userr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void addUser(Userr user){
        userRepo.save(user);
    }


}
