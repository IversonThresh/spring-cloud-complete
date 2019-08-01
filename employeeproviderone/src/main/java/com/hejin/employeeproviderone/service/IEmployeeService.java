package com.hejin.employeeproviderone.service;

import com.hejin.parententity.entity.Employee;

import java.util.List;

/**
 * @Author: hejin
 * @Date: 2019/8/1 13:39
 */
public interface IEmployeeService {
    List<Employee> searchUserById(int id);
}
