package com.pro.sky.Emloyees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/departament")
public class DepartamentController {
    private final DepartamentInterface depart;


    public DepartamentController(DepartamentInterface depart, EmployeeInterface employee) {
        this.depart = depart;

    }

    @GetMapping
    public String hello() {
        return "Приветствуем в разделе отделов";
    }


    @GetMapping(path = "/add")
    public void addDepar(@RequestParam("id") int idDepart, @RequestParam("name") String nameDepart) {
        depart.addDepart(idDepart, nameDepart);

    }

    @GetMapping(path = "/list")
    public String listDepart() {
        return depart.listDepartament().toString();

    }

    @GetMapping(path = "/employees")
    public ArrayList employeesinDepart(@RequestParam("depart") int numDepart) {
        return depart.employeesInDepart(numDepart);
    }

    @GetMapping(path = "/salary")
    private int sumSalaryInDepart(@RequestParam("depart") int numDepart) {
        return depart.expensesSalaryInDepart(numDepart);
    }

    @GetMapping(path = "/salary/max")
    private int maxSalaryInDepart(@RequestParam("depart") int numDepart) {
        return depart.maxSalaryInDepart(numDepart);
    }

    @GetMapping(path = "/salary/min")
    private int minSalaryInDepart(@RequestParam("depart") int numDepart) {
        return depart.minSalaryInDepart(numDepart);
    }

    @GetMapping(path = "/salary/mid")
    private float midSalaryInDepart(@RequestParam("depart") int numDepart) {
        return depart.midSalaryInDepart(numDepart);
    }

}

