package com.springboot.jpademo.entity;

import lombok.Cleanup;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "t_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 3745798392138347131L;
    private Long id;
    private String name;
    private Date birthday;
    private int sex;
    private String address;
    private Set<Teacher> teacherSet;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, precision = 22)
    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(name = "sex")
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "t_teacher_student",
            joinColumns = @JoinColumn(name = "stu_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id",referencedColumnName = "id"))
    public Set<Teacher> getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set<Teacher> teacherSet) {
        this.teacherSet = teacherSet;
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
