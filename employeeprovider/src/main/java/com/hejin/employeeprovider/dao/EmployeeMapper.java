package com.hejin.employeeprovider.dao;

import com.hejin.parententity.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: hejin
 * @Date: 2019/8/1 11:51
 */
@Mapper
public interface EmployeeMapper {
    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    List<Employee> queryEmployeeById(int id);
}
