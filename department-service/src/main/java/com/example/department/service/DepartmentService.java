package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        log.debug("inside save method of Department Service");
        return departmentRepository.save(department);
    }

    public Department findById(long id) {
        log.debug("inside findById method of Department Service");
        return departmentRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
