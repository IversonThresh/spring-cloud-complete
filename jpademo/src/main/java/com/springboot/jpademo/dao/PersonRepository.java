package com.springboot.jpademo.dao;

import com.springboot.jpademo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    //自定义接口
    //通过年龄来查询
    public List<Person> findByAge(Integer age);
}
