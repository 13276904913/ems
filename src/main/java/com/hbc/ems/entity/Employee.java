package com.hbc.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private Integer id;

    private String name;

    private Double salary;

    private Integer age;

    private static final long serialVersionUID = 1L;


}