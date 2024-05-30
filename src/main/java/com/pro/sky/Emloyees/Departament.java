package com.pro.sky.Emloyees;

import java.util.ArrayList;
import java.util.Objects;

public class Departament {
    private int numDepart;
    private String nameDepart;
    private ArrayList<Integer> employeesList;


    public Departament(int numDepart, String nameDepart) {
        this.numDepart = numDepart;

        this.nameDepart = nameDepart;

        this.employeesList = new ArrayList<>();
    }


    public String getNameDepart() {
        return nameDepart;
    }

    public int getNumDepart() {
        return numDepart;
    }


    @Override
    public String toString() {
        return numDepart + " " + nameDepart + " " + employeesList;
    }

    public ArrayList getEmployeesList() {
        return employeesList;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Departament that = (Departament) object;
        return numDepart == that.numDepart && Objects.equals(nameDepart, that.nameDepart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numDepart, nameDepart);
    }
}