package com.springboot.jpademo.controller;

import com.springboot.jpademo.dao.PersonRepository;
import com.springboot.jpademo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    /**
     * 添加一个人的信息
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/preson/post/{id}")
    public Person personAdd(@PathVariable("id") Integer id,
                            @RequestParam("name") String name,
                            @RequestParam("age") Integer age){
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        return personRepository.save(person);
    }
    /**
     * 查询所有人的数据
     * 分页查询，page从0开始
     * @return
     */
    @GetMapping(value = "/personlist")
    public Page<Person> personList(){
        PageRequest pageList = PageRequest.of(0, 2, Sort.Direction.ASC, "id");
        return personRepository.findAll(pageList);
    }

    /**
     * 通过id查询某个人的信息
     * @param id
     * @return
     */
    @GetMapping(value = "/person/get/{id}")
    public Person personFindOne(@PathVariable("id") Integer id){
        return personRepository.findById(id).get();
    }

    /**
     * 更新数据
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping(value = "/person/put/{id}")
    public Person updateperson(@PathVariable("id") Integer id,
                               @RequestParam("name") String name,
                               @RequestParam("age") Integer age){
        Person person = new Person();
        person.setId(id);
        person.setAge(age);
        person.setName(name);
        return personRepository.save(person);
    }

    /**
     * 通过 id 删除数据
     * @param id
     */
    @DeleteMapping(value = "/person/delete/{id}")
    public void personDelete(@PathVariable("id") Integer id){
        personRepository.deleteById(id);
    }

    /**
     * 自定义通过年龄查询用户信息接口
     * @param age
     * @return
     */
    @GetMapping(value = "/person/age/{age}")
    public List<Person> personListByAge( @PathVariable("age") Integer age){
        return personRepository.findByAge(age);
    }
}
