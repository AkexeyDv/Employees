package com.pro.sky.Emloyees;

public class Employee {
    private int id = 0;
    private String lastname;
    private String name;
    private String surname;
    private int salary;

    public Employee(int id,String lastname, String name, String surname, int salary, int numDepart) {
        this.id=id;
        this.lastname = lastname;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + lastname + " " + name + " " + surname;
    }
}
