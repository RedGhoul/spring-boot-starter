package com.somethingsblog.springboot.start.service;

import com.somethingsblog.springboot.start.entity.Department;
import com.somethingsblog.springboot.start.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    boolean deleteDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    Department fetchDepartmentByName(String name);
}
