package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/")
    public Department save(@RequestBody Department department){
        log.debug("inside save method of Department Controller");
        return departmentService.save(department);
    }

    @GetMapping(value = "/{id}")
    public Department findById(@PathVariable(value = "id") long id){
        log.debug("inside findById method of Department Controller");
        return departmentService.findById(id);
    }
}
