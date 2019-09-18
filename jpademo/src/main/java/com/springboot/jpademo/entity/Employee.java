package com.springboot.jpademo.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "e_employee")
public class Employee {
    @Id
    @GenericGenerator(name = "myuuid", strategy = "uuid")
    @GeneratedValue(generator = "myuuid")
    @Column(name = "e_id")
    private String id;
    @Column(name = "e_name")
    @Type(type = "string")
    private String name;
    @Column(name = "e_money")
    private Double money;
    @JoinColumn(name = "b_boss_b_id")
    @ManyToOne(targetEntity = Boss.class)
    private Boss boss;

    public Employee() {
    }

    public Employee(String id, String name, Double money, Boss boss) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.boss = boss;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
