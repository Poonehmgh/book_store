package com.bookz.store.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @PostMapping()
    public String createUser(@RequestBody String user){
        return "User created mama mia cassela!dbhvnl";
    }

}
