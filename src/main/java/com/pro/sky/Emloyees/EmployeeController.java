package com.pro.sky.Emloyees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping(path = "/employee")
@RestController
public class EmployeeController {
    private final EmployeeInterface employee;

    public EmployeeController(EmployeeInterface employee) {
        this.employee = employee;
    }

    @GetMapping
    public String hello() {
        return "Приветствуем в отделе сотрудников";
    }

    @GetMapping(path = "/add")
    public String addEmployee(
            @RequestParam("lastname") String lastName,
            @RequestParam("name") String name,
            @RequestParam("surname") String surName,
            @RequestParam("salary") int salary,
            @RequestParam("depart") int numDepart) {
        return employee.addEmployee(lastName, name, surName, salary, numDepart) + " добавлен";
    }

    @GetMapping(path = "/salary")
    public int expensesSalary() {
        return employee.expensesSalary();
    }

    @GetMapping(path = "/salary/max")
    public int maxSalary() {
        return employee.maxSalary();
    }

    @GetMapping(path = "/salary/min")
    public int minSalary() {
        return employee.minSalary();
    }

    @GetMapping(path = "/salary/mid")
    public float midSalary() {
        return employee.midSalary();
    }

    @GetMapping(path = "/salary/percent")
    public void percentSalary(@RequestParam("percent") int percent) {
        employee.salaryPercent(percent);
    }

    @GetMapping(path = "/list")
    public ArrayList listEmployee() {
        return employee.employeesList();
    }


}
