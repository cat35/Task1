package com.innotechnum.task1.pojo;


import java.util.ArrayList;
import java.util.List;

public class Department {

    private String nameDep;

    private List<Employees> listOfEmployees;

    public Department(String nameDep, List<Employees> listOfEmployees) {
        this.nameDep = nameDep;
        this.listOfEmployees = listOfEmployees;
    }

    public List<Employees> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(List<Employees> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }


    public String getNameDep() {
        return nameDep;
    }

    public void setNameDep(String nameDep) {
        this.nameDep = nameDep;
    }


}
