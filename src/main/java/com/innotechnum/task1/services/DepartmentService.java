package com.innotechnum.task1.services;

import com.innotechnum.task1.pojo.Department;
import com.innotechnum.task1.pojo.Employees;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    public BigDecimal averageSalary(Department department){

        BigDecimal sum = department.getListOfEmployees().stream().map(Employees::getSalary).reduce(BigDecimal::add).get();
        BigDecimal average = new BigDecimal(String.valueOf(sum)).divide(BigDecimal.valueOf(department.getListOfEmployees().size()), RoundingMode.HALF_UP);

        return average;
    }

    public void transfer(Department dep1, Department dep2, Employees e){
        dep1.getListOfEmployees().remove(e);
        dep2.getListOfEmployees().add(e);
    }

    public void findSalary(Department department1, Department department2){

        if(averageSalary(department1).compareTo(averageSalary(department2)) > 0){
            
        }

    }


}
