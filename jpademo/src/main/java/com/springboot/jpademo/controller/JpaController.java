package com.springboot.jpademo.controller;

import com.springboot.jpademo.dao.BossRepositiory;
import com.springboot.jpademo.dao.EmployeeRepository;
import com.springboot.jpademo.entity.Boss;
import com.springboot.jpademo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class JpaController {
    @Autowired
    private BossRepositiory genericRepositiory;
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("jpa")
    public String jpaMethod() {
        return "jpa hibernate";
    }

    @RequestMapping("setBossEmployeeVal")
    @Transactional
    public String setBossEmployeeVal() {
        Boss boss = new Boss();
        boss.setDate(new Date());
        boss.setName("何老板");

        Employee employee = new Employee();
        employee.setMoney(1000d);
        employee.setName("员工一");

        Employee employee1 = new Employee();
        employee1.setMoney(2000d);
        employee1.setName("员工二");

        boss.getEmployees().add(employee);
        boss.getEmployees().add(employee1);

        employee.setBoss(boss);
        employee1.setBoss(boss);

        genericRepositiory.save(boss);
        employeeRepository.save(employee);
        employeeRepository.save(employee1);
        return "success";
    }

    @RequestMapping("deletePersonById")
    @Transactional
    public String deletePersonById() {
        try {
            genericRepositiory.deleteById(5);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除的人员不存在");
        }
        return "delete success";
    }
}
