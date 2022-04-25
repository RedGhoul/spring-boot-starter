package com.somethingsblog.springboot.start.service;

import com.somethingsblog.springboot.start.entity.Department;
import com.somethingsblog.springboot.start.repo.DepartmentRepo;
import lombok.ToString;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepo departmentRepo;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Toronto")
                .departmentCode("JJDD")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepo.findDepartmentByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Get Data Based On Valid Name")
    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}