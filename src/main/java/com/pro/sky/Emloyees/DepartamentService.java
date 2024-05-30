package com.pro.sky.Emloyees;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.pro.sky.Emloyees.EmployeeService.employeeList;

@Service
public class DepartamentService implements DepartamentInterface {
    //переменная испосльзуется в EmployeeService, по этой причине только protected
    protected static final ArrayList<Departament> departList = new ArrayList<>();

    //добавление нового отдела
    @Override
    public Departament addDepart(int numDepart, String nameDepart) {


        if (checkNumDepart(numDepart)) {
            throw new ExceptionDepartament("Отдел с таким номером уже существует");
        }
        if (findNameDepart(nameDepart)) {
            throw new ExceptionDepartament("Отдел с таким названием уже существует");
        }
        Departament newDepart = new Departament(numDepart, nameDepart);
        departList.add(newDepart);
        return newDepart;
    }

    @Override
    public ArrayList<Departament> listDepartament() {
        return departList;
    }

    //добавление id сотрудника в отдел
    @Override
    public void addEmployeeInDepart(int idEmployee, int numDepart) {
        if (checkNumDepart(numDepart)) {
            findDepartByNum(numDepart).getEmployeesList().add(idEmployee);
        }
        throw new ExceptionDepartament("Вы указали отсутствующий отдел");

    }

    //проверка наличия отдела
    public Boolean checkNumDepart(int numDepart) {
        for (Departament departament : departList) {
            if (departament.getNumDepart() == numDepart) {
                return true;
            }

        }
        return false;
    }

    //поиск номера отдела
    public Departament findDepartByNum(int numDepart) {
        for (Departament departament : departList) {
            if (departament.getNumDepart() == numDepart) {
                System.out.println(departament);
                return departament;
            }
        }
        throw new ExceptionDepartament("Вы ввели несуществующий номер отдела");
    }

    private Boolean findNameDepart(String nameDepart) {
        for (Departament departament : departList) {
            if (departament.getNameDepart().equals(nameDepart)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public ArrayList<Departament> getDepartList() {
        return departList;
    }

    // четыре зарплатных метода
    @Override
    public int expensesSalaryInDepart(int numDepart) {
        if (!checkNumDepart(numDepart)) {
            throw new ExceptionDepartament("Вы ввели несуществующий номер отдела");
        }
        int summSalaryInDepart = 0;
        for (Employee employee : employeesInDepart(numDepart)) {
            summSalaryInDepart = summSalaryInDepart + employee.getSalary();
        }

        return summSalaryInDepart;
    }

    @Override
    public int maxSalaryInDepart(int numDepart) {
        if (!checkNumDepart(numDepart)) {
            throw new ExceptionDepartament("Вы ввели несуществующий номер отдела");
        }
        int sumMaxSalary = 0;
        for (Employee employee : employeesInDepart(numDepart)) {
            if (employee.getSalary() > sumMaxSalary) {
                sumMaxSalary = employee.getSalary();
            }
        }
        return sumMaxSalary;
    }

    @Override
    public int minSalaryInDepart(int numDepart) {
        if (!checkNumDepart(numDepart)) {
            throw new ExceptionDepartament("Вы ввели несуществующий номер отдела");
        }
        int sumMinSalary = Integer.MAX_VALUE;
        for (Employee employee : employeesInDepart(numDepart)) {
            if (employee.getSalary() < sumMinSalary) {
                sumMinSalary = employee.getSalary();
            }
        }
        return sumMinSalary;
    }

    @Override
    public float midSalaryInDepart(int numDepart) {
        if (!checkNumDepart(numDepart)) {
            throw new ExceptionDepartament("Вы ввели несуществующий номер отдела");
        }
        if (countEmployeeInDepart(numDepart) == 0) {
            return 0;
        }
        return (float) expensesSalaryInDepart(numDepart) / countEmployeeInDepart(numDepart);
    }

    //Количество сотрудников в отделе
    public int countEmployeeInDepart(int numDepart) {
        if (!checkNumDepart(numDepart)) {
            throw new ExceptionDepartament("Вы ввели несуществующий номер отдела");
        }
        return employeesInDepart(numDepart).size();
    }

    //Лист сотрудников отдела
    //из конкретного отдела извлекается поле ListArray с id сотрудников
    //по этому листу выбираем сотрудников из листа сотрудников, находящегося в EmployeeService
    //и создаем лист из отобранных сотрудников - получем лист с сотрудниками отдела
    @Override
    public ArrayList<Employee> employeesInDepart(int numThisDepart) {
        if (!checkNumDepart(numThisDepart)) {
            throw new ExceptionDepartament("Вы ввели несуществующий номер отдела");
        }
        ArrayList<Employee> listEmployeeDepart = new ArrayList<>();
        ArrayList<Integer> listIdEmployees = findDepartByNum(numThisDepart).getEmployeesList();
        for (Integer idEmployee : listIdEmployees) {
            for (Employee employee : employeeList) {
                if (idEmployee == employee.getId()) {
                    listEmployeeDepart.add(employee);
                }
            }
        }
        return listEmployeeDepart;


    }

    @Override
    public String toString() {
        return departList + " ";
    }
}
