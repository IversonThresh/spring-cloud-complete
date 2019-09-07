package com.hejin.parententity.entity;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("applicationContext.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        Student student = (Student) xmlBeanFactory.getBean("studentbean");
        student.displayInfo();

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student studentbean = (Student) classPathXmlApplicationContext.getBean("studentbean");
        studentbean.setName("hejin");
        studentbean.displayInfo();
    }
}
