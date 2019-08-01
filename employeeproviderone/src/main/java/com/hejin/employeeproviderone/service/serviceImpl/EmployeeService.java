package com.hejin.employeeproviderone.service.serviceImpl;

import com.hejin.employeeproviderone.dao.EmployeeMapper;
import com.hejin.employeeproviderone.service.IEmployeeService;
import com.hejin.parententity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hejin
 * @Date: 2019/8/1 13:40
 */
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> searchUserById(int id) {
        return employeeMapper.queryEmployeeById(id);
    }
}
