package com.somethingsblog.springboot.start.service;

import com.somethingsblog.springboot.start.entity.Department;
import com.somethingsblog.springboot.start.error.DepartmentNotFoundException;
import com.somethingsblog.springboot.start.repo.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        var department = departmentRepo.findById(id);
        if(department.isEmpty()) throw new DepartmentNotFoundException("Department not found");
        return department.get();
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        var department = departmentRepo.findById(id);
        if(department.isPresent()){
            departmentRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        var departmentFromDB = departmentRepo.findById(id);
        if(departmentFromDB.isPresent()){
            var realDepartment = departmentFromDB.get();
            if(department.getDepartmentAddress() != null &&
                    !department.getDepartmentAddress().equals(
                            realDepartment.getDepartmentAddress())){
                realDepartment.setDepartmentAddress(department.getDepartmentAddress());
            }
            if(department.getDepartmentCode() != null &&
                    !department.getDepartmentCode().equals(
                            realDepartment.getDepartmentCode())){
                realDepartment.setDepartmentCode(department.getDepartmentCode());
            }
            if(department.getDepartmentName() != null &&
                    !department.getDepartmentName().equals(
                            realDepartment.getDepartmentName())){
                realDepartment.setDepartmentName(department.getDepartmentName());
            }
            departmentRepo.save(realDepartment);
            return realDepartment;
        }
        return null;
    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepo.findDepartmentByDepartmentNameIgnoreCase(name);
    }
}
