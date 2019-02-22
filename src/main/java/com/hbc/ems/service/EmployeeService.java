package com.hbc.ems.service;

import com.hbc.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    void add(Employee employee);

    void removeById(Integer id);

    void motify(Employee employee);

    Employee getById(Integer id);
}
