package com.innotechnum.task1;

import java.util.ArrayList;

public class Department {

    private String nameDep;

    private ArrayList<Employees> listOfEmployees;

    public ArrayList<Employees> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(ArrayList<Employees> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    public Department(String nameDep, ArrayList<Employees> listOfEmployees) {
        this.nameDep = nameDep;
        this.listOfEmployees = listOfEmployees;
    }

    public Department(String nameDep) {
        this.nameDep = nameDep;
    }

    public String getNameDep() {
        return nameDep;
    }

    public void setNameDep(String nameDep) {
        this.nameDep = nameDep;
    }


}
