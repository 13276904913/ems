package com.hbc.ems.service.impl;

import com.hbc.ems.dao.EmployeeMapper;
import com.hbc.ems.entity.Employee;
import com.hbc.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public void add(Employee employee) {
        if (employee == null) {
            return;
        }
        employeeMapper.insert(employee);
    }

    @Override
    public void removeById(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void motify(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    @Override
    public Employee getById(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }
}
