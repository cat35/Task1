package com.innotechnum.task1.services;

import com.innotechnum.task1.pojo.Department;
import com.innotechnum.task1.pojo.Employees;

import java.math.BigDecimal;
import java.math.RoundingMode;



public class DepartmentService {

    public BigDecimal averageSalary(Department department) {


        BigDecimal sum = department.getListOfEmployees().stream().map(Employees::getSalary).reduce(BigDecimal::add).get();
        if (department.getListOfEmployees().size() > 0) {
            BigDecimal average = sum.divide(BigDecimal.valueOf(department.getListOfEmployees().size()), RoundingMode.HALF_UP);

            return average;
        } else
            System.out.println("делить на ноль нельзя");
        return null;
    }

    public void transfer(Department dep1, Department dep2, Employees e) {
        if (dep1.getListOfEmployees().contains(e))
            dep1.getListOfEmployees().remove(e);
        else
            System.out.println("В отделе отсутствует сотрудник");
        if (dep1.getListOfEmployees().remove(e))
            dep2.getListOfEmployees().add(e);
        else
            System.out.println("Ошибка добавления сотрудника в новый отдел");
    }

    public boolean findTransfer(Department department1, Department department2) {


        if (department1.getListOfEmployees().size() == department2.getListOfEmployees().size() && department1.getListOfEmployees().size() != 0) {
            BigDecimal max = department1.getListOfEmployees().stream().map(Employees::getSalary).max(BigDecimal::compareTo).get();
            BigDecimal min = department2.getListOfEmployees().stream().map(Employees::getSalary).min(BigDecimal::compareTo).get();



            return min.compareTo(max) > 0;
        }
        return false;
    }


}
