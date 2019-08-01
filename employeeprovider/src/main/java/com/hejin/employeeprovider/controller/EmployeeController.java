package com.hejin.employeeprovider.controller;

import com.hejin.employeeprovider.service.IEmployeeService;
import com.hejin.parententity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: hejin
 * @Date: 2019/8/1 13:42
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/findById")
    public Employee searchUserById(int id) {
        List<Employee> employees = employeeService.searchUserById(id);
        Employee employee = employees.get(0);
        System.out.println(employee.toString());
        return employee;
    }
}
