package com.somethingsblog.springboot.start.repo;

import com.somethingsblog.springboot.start.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    public Department findDepartmentByDepartmentNameIgnoreCase(String name);
}
