package com.example.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping(value = "/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service is taking longer than expected, Please try again later";
    }

    @GetMapping(value = "/departmentServiceFallBack")
    public String DepartmentServiceFallBackMethod(){
        return "Department Service is taking longer than expected, Please try again later";
    }
}
