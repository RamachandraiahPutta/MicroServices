package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/")
    public User save(@RequestBody User user){
        log.debug("inside save method of UserController");
        return userService.save(user);
    }

    @GetMapping(value = "/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable(value = "id") long id){
        log.debug("inside findById method of UserController");
        return userService.getUserWithDepartment(id);

    }
}
