package com.pro.sky.Emloyees;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.pro.sky.Emloyees.DepartamentService.departList;

@Service
public class EmployeeService implements EmployeeInterface {
    protected static final ArrayList<Employee> employeeList = new ArrayList<>();
    private int idEmployee = 0;

    public Boolean checkNumDepart(int numDepart) {
        for (Departament departament : departList) {
            if (departament.getNumDepart() == numDepart) {
                return true;
            }

        }
        return false;
    }

    @Override
    public Employee addEmployee(
            String lastName,
            String name,
            String surName,
            int salary,
            int numDepartEmployee) {
        if (!checkNumDepart(numDepartEmployee)) {
            throw new ExceptionEmployee("Помещатете сотрудника в несуществующий отдел");
        }
        Departament depart;
        idEmployee++;
        Employee newEmployee = new Employee(idEmployee, lastName, name, surName, salary, numDepartEmployee);
        System.out.println("Добавляю сотрудника" + newEmployee);
        employeeList.add(newEmployee);
        System.out.println(employeeList);
        for (Departament departament : departList) {
            if (departament.getNumDepart() == numDepartEmployee) {
                depart = departament;
                depart.getEmployeesList().add(newEmployee.getId());
            }

        }

        return newEmployee;
    }

    @Override
    public Employee findEmployeeById(int idEmployee) {
        if ((long) employeeList.size() == 0) {
            throw new ExceptionEmployee("Нет ни одного сотрудника");
        }
        for (Employee employee : employeeList) {
            if (employee.getId() == idEmployee) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public int expensesSalary() {
        if ((long) employeeList.size() == 0) {
            throw new ExceptionEmployee("Нет ни одного сотрудника");
        }
        int expenses = 0;
        for (Employee employee : employeeList) {
            expenses = expenses + employee.getSalary();
        }
        return expenses;
    }

    @Override
    public int maxSalary() {
        if ((long) employeeList.size() == 0) {
            throw new ExceptionEmployee("Нет ни одного сотрудника");
        }
        int salary = 0;
        for (Employee employee : employeeList) {
            if (employee.getSalary() > salary) {
                salary = employee.getSalary();
            }
        }
        return salary;
    }

    @Override
    public int minSalary() {
        if ((long) employeeList.size() == 0) {
            throw new ExceptionEmployee("Нет ни одного сотрудника");
        }
        int salary = Integer.MAX_VALUE;
        for (Employee employee : employeeList) {
            if (employee.getSalary() < salary) {
                salary = employee.getSalary();
            }
        }
        return salary;
    }

    @Override
    public float midSalary() {
        if ((long) employeeList.size() == 0) {
            throw new ExceptionEmployee("Нет ни одного сотрудника");
        }
        return (float) expensesSalary() / (long) employeeList.size();
    }

    @Override
    public void salaryPercent(float percent) {
        for (Employee employee : employeeList) {
            employee.setSalary((int) (employee.getSalary() * (1 + percent / 100)));
        }
    }

    @Override
    public ArrayList<Employee> employeesList() {
        return employeeList;
    }

}