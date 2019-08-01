package com.hejin.parententity.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: hejin
 * @Date: 2019/8/1 11:37
 */
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 8091904743354453581L;

    private int id;
    private String name;
}
