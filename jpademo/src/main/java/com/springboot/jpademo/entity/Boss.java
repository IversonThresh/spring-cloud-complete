package com.springboot.jpademo.entity;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "b_boss")
public class Boss {
    @Id
    @Column(name = "b_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "b_name",length = 50)
    @Type(type = "string")
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "b_date")
    private Date date;
    @OneToMany(targetEntity = Employee.class, mappedBy = "boss")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Employee> employees = new HashSet<>();

    public Boss() {
        super();
    }

    public Boss(Integer id, String name, Date date, Set<Employee> employees) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
