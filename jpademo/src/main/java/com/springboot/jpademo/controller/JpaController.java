package com.springboot.jpademo.controller;

import com.springboot.jpademo.dao.BossRepositiory;
import com.springboot.jpademo.dao.StudentRepository;
import com.springboot.jpademo.entity.Boss;
import com.springboot.jpademo.entity.Employee;
import com.springboot.jpademo.entity.Student;
import com.springboot.jpademo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashSet;

@RestController
public class JpaController {
    @Autowired
    private BossRepositiory genericRepositiory;
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("jpa")
    public String jpaMethod() {
        return "jpa hibernate";
    }

    @RequestMapping("setBossEmployeeVal")
    @Transactional
    public String setBossEmployeeVal() {
        Boss boss = new Boss();
        boss.setDate(new Date());
        boss.setName("王老板");

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
        return "success";
    }

    @RequestMapping("deletePersonById")
    @Transactional
    public String deletePersonById() {
        try {
            genericRepositiory.deleteById(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除的人员不存在");
        }
        return "delete success";
    }

    @RequestMapping("addStudentTeacher")
    @Transactional(rollbackFor = Exception.class)
    public String addStudentTeacher() {
        Student student = new Student();
        student.setName("小朱");
        Teacher teacher = new Teacher();
        teacher.setName("伟都");
        HashSet<Teacher> teachers = new HashSet<>();
        teachers.add(teacher);
        student.setTeacherSet(teachers);
        studentRepository.save(student);

        return "add student teacher sucess";
    }
}
