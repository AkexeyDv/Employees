package com.pro.sky.Emloyees;

import java.util.ArrayList;

public interface EmployeeInterface {


    Employee addEmployee(
            String lastName,
            String name,
            String surName,
            int salary,
            int numDepart);

    Employee findEmployeeById(int idEmployee);

    int expensesSalary();

    int maxSalary();

    int minSalary();

    float midSalary();


    void salaryPercent(float percent);

    ArrayList employeesList();
}