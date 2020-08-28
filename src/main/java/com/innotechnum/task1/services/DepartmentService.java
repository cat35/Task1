package com.innotechnum.task1.services;

import com.innotechnum.task1.pojo.Department;
import com.innotechnum.task1.pojo.Employees;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class DepartmentService {

    public List<String> allVariantsOfTransfers = new ArrayList<>();

    public static BigDecimal averageSalary(Department department) {


        BigDecimal sum = department.getListOfEmployees().stream().map(Employees::getSalary).reduce(BigDecimal::add).get();
        if (department.getListOfEmployees().size() > 0) {
            BigDecimal average = sum.divide(BigDecimal.valueOf(department.getListOfEmployees().size()), 2, RoundingMode.HALF_UP);

            return average;
        } else
            throw new ArithmeticException();
    }


    public List<String> findTransfer(List<Department> depList) {
        List<Employees> list = new ArrayList<>();

        for (Department department1 : depList) {
            Iterator<Employees> it = department1.getListOfEmployees().iterator();

            for (Department department2 : depList) {

                if (department1.getNameDep().equals(department2.getNameDep()))
                    continue;
                while (it.hasNext()) {
                    Employees e = it.next();
                    if (e.getSalary().compareTo(averageSalary(department1)) < 0 && e.getSalary().compareTo(averageSalary(department2)) > 0) {
                        list.add(e);
                    }

                }
                addVariants(department1, department2, list);
            }

        }
        return allVariantsOfTransfers;
    }

    public void addVariants(Department dep1, Department dep2, List<Employees> list) {
        StringBuilder var = new StringBuilder("Работники: \n");
        for (Employees employees : list)
            var.append(employees).append("\n");
        var.append("Отдел: ").append(dep1.getNameDep()).append(" Можно перевести в отдел: ").append(dep2.getNameDep())
                .append("\n Средняя зарплата до перевода в первом отделе ").append(averageSalary(dep1)).append("\nВо втором ").append(averageSalary(dep2))
                .append(" Средняя зарплата после перевода\n");

        dep1.getListOfEmployees().removeAll(list);
        dep2.getListOfEmployees().addAll(list);


        var.append(" Средняя зарплата в первом отделе ").append(averageSalary(dep1)).append("\nВо втором отделе ").append(averageSalary(dep2)).append("\n");

        allVariantsOfTransfers.add(var.toString());
    }
}
