package com.pro.sky.Emloyees;

import java.util.ArrayList;

public interface DepartamentInterface {
    Departament addDepart(int numDepart, String nameDepart);

    ArrayList<Departament> listDepartament();

    void addEmployeeInDepart(int idEmployee, int numDepart);

    ArrayList getDepartList();

    int expensesSalaryInDepart(int numDepart);

    int maxSalaryInDepart(int numDepart);

    int minSalaryInDepart(int numDepart);

    float midSalaryInDepart(int numDepart);

    ArrayList<Employee> employeesInDepart(int numDepart);
}
