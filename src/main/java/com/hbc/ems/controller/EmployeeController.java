package com.hbc.ems.controller;

import com.hbc.ems.entity.Employee;
import com.hbc.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SpringBootApplication
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/showAll")
    public String showAll(HttpServletRequest req) {
        List<Employee> list = employeeService.getAll();
        req.setAttribute("list", list);
        return "emplist";
    }

    @RequestMapping("/add")
    public String add(Employee employee) {
        employeeService.add(employee);
        return "redirect:/employee/showAll";
    }

    @RequestMapping("/removeById")
    public String removeById(Integer id) {
        employeeService.removeById(id);
        return "redirect:/employee/showAll";
    }

    @RequestMapping("/motifyBegin")
    public String motifyBegin(Integer id, HttpServletRequest req) {
        Employee employee = employeeService.getById(id);
        req.setAttribute("employee", employee);
        return "updateEmp";
    }

    @RequestMapping("/motifyEnd")
    public String motifyEnd(Employee employee) {
        employeeService.motify(employee);
        return "redirect:/employee/showAll";
    }
}
