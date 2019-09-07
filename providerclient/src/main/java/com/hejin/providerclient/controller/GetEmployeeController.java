package com.hejin.providerclient.controller;

import com.hejin.parententity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: hejin
 * @Date: 2019/8/1 14:31
 */
@RestController
@RequestMapping("getEmployeeController")
public class GetEmployeeController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FeginService feginService;

    //@Autowired
    //private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public Employee findById(@PathVariable int id) {
        Employee employee = this.restTemplate.getForObject("http://employee-msg-provider/employee/findById?id=" + id, Employee.class);
        return employee;
    }

    @RequestMapping("testFeign")
    public String testFeign() {
        return feginService.hello();
    }

    @RequestMapping("feignFindById")
    public String feignFindById(int id) {
        return feginService.findById(id);
    }
}
