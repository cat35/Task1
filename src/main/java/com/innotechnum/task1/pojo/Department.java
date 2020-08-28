package com.innotechnum.task1.pojo;


import java.util.List;

public class Department {

    private final String nameDep;

    private final List<Employees> listOfEmployees;

    public Department(String nameDep, List<Employees> listOfEmployees) {
        this.nameDep = nameDep;
        this.listOfEmployees = listOfEmployees;
    }

    public List<Employees> getListOfEmployees() {
        return listOfEmployees;
    }


    public String getNameDep() {
        return nameDep;
    }


    public void addEmployee(Employees e) {
        this.listOfEmployees.add(e);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employees e : listOfEmployees) {
            stringBuilder.append(e.toString()).append("\r\n");

        }
        return stringBuilder.toString();
    }

}
