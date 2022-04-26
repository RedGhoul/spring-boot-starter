package com.somethingsblog.springboot.start.controller;

import com.somethingsblog.springboot.start.entity.Department;
import com.somethingsblog.springboot.start.error.DepartmentNotFoundException;
import com.somethingsblog.springboot.start.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside post creation");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        LOGGER.info("get all departments");
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        LOGGER.info("get single department");
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public boolean deleteDepartmentById(@PathVariable("id") Long id){
        LOGGER.info("delete single department");
        return departmentService.deleteDepartmentById(id);
    }

    @PutMapping ("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long id, @Valid @RequestBody Department department){
        LOGGER.info("update single department");
        return departmentService.updateDepartment(id,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String name){
        LOGGER.info("get single department by name");
        return departmentService.fetchDepartmentByName(name);
    }
}
