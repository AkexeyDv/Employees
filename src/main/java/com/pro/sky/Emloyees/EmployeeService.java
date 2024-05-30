package com.pro.sky.Emloyees;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.pro.sky.Emloyees.DepartamentService.departList;

@Service
public class EmployeeService implements EmployeeInterface {
    protected static final ArrayList<Employee> employeeList = new ArrayList<>();
    //автоматическое назначение id сотрудника
    private int idEmployee = 0;

    //Проверка существования отдела с указанным номером
    public Boolean checkNumDepart(int numDepart) {
        for (Departament departament : departList) {
            if (departament.getNumDepart() == numDepart) {
                return true;
            }

        }
        return false;
    }

    //добавление нового сотрудника
    //сотрудник создается со своим id и этот ид одновременно помещается
    //в поле employeesList(ArrayList) указанного отдела
    //Проверка на ФИО сотрудника не происходит, т.к. в реальности возможно полное совпадение
    //отличие происходит только по id.
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
        if (!checkEmployee(idEmployee+1)){
            throw new ExceptionEmployee("Что-то пошло не так: сотрудник с таким id существует");
        }
        idEmployee++;
        Employee newEmployee = new Employee(idEmployee, lastName, name, surName, salary, numDepartEmployee);
        employeeList.add(newEmployee);
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
        throw new ExceptionEmployee("Сотрудник с таким id отсутствует");
    }

    private Boolean checkEmployee(int idEmployee) {
        for (Employee employee : employeeList) {
            if (employee.getId() == idEmployee) {
                return true;
            }
        }
        return false;
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