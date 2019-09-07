package com.hejin.providerclient.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "employee-msg-provider")
public interface FeginService {
    @RequestMapping("/employee/hello")
    String hello();

    @RequestMapping(value = "/employee/findById", method= RequestMethod.GET)
    String findById(@RequestParam("id") int name) ;
}
