package com.capstone.controller;

import com.capstone.model.User;
import com.capstone.repository.UserRepository;
import com.capstone.request.LoginRequest;
import com.capstone.service.UserService;
import com.capstone.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public Result<Object> createUser(@RequestBody LoginRequest loginRequest) throws Exception{

        if (userService.findByUsername(loginRequest) == false) {
            return Result.error("User name is already taken");
        }
        User user = userService.saveUser(loginRequest);

        return Result.success("signup success");
    }

    @PostMapping("/signin")
    public Result<Object> signinHandler(@RequestBody LoginRequest loginRequest){
        User user = userService.signinHandler(loginRequest);

        return Result.success("signin success");

    }




}
