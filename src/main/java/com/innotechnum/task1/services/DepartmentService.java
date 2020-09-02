package com.innotechnum.task1.services;

import com.innotechnum.task1.pojo.Department;
import com.innotechnum.task1.pojo.Employees;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class DepartmentService {

    public List<String> allVariantsOfTransfers = new ArrayList<>();

    public BigDecimal averageSalary(List<Employees> list) {


        BigDecimal sum = list.stream().filter(Objects::nonNull).map(Employees::getSalary).reduce(BigDecimal::add).get();
        if (list.size() > 0) {
            BigDecimal average = sum.divide(BigDecimal.valueOf(list.size()), 2, RoundingMode.HALF_UP);

            return average;
        } else
            throw new ArithmeticException();
    }

    public List<String> findTransfer(List<Department> deplist){
        for (Department depOut : deplist){
            List<List<Employees>> allTransfers = search(depOut.getListOfEmployees(), 0, new ArrayList<>(), averageSalary(depOut.getListOfEmployees()));
            for (Department depIn : deplist){
                if (depOut.getNameDep().equals(depIn.getNameDep()))
                    continue;
                for (List<Employees> list : allTransfers){
                    if (averageSalary(list).compareTo(averageSalary(depIn.getListOfEmployees())) > 0)
                        addVariants(depOut, depIn, list);
                }
            }
        }
        return allVariantsOfTransfers;
    }


    public void addVariants(Department dep1, Department dep2, List<Employees> list) {
        StringBuilder var = new StringBuilder("Работники: \n");
        for (Employees employees : list)
            var.append(employees).append("\n");
        var.append("Отдел: ").append(dep1.getNameDep()).append(" Можно перевести в отдел: ").append(dep2.getNameDep())
                .append("\n Средняя зарплата до перевода в первом отделе ").append(averageSalary(dep1.getListOfEmployees())).append("\nВо втором ").append(averageSalary(dep2.getListOfEmployees()))
                .append(" Средняя зарплата после перевода\n");

        List<Employees> list1 = dep1.getListOfEmployees();
        List<Employees> list2 = dep2.getListOfEmployees();

        list1.removeAll(list);
        list2.addAll(list);


        var.append(" Средняя зарплата в первом отделе ").append(averageSalary(list1)).append("\nВо втором отделе ").append(averageSalary(list2)).append("\n");

        allVariantsOfTransfers.add(var.toString());
    }

    public List<List<Employees>> search(List<Employees> immutableList, int begin, List<Employees> list, BigDecimal averageSalaryFrom) {
        List<List<Employees>> allTransfers = new ArrayList<>();
        for (int i = begin; i < immutableList.size(); i++) {
            List<Employees> list1 = new ArrayList<>(list);
            list1.add(immutableList.get(i));
            if (averageSalary(list1).compareTo(averageSalaryFrom) < 0) {
                allTransfers.add(list1);
            }
            allTransfers.addAll(search(immutableList, i+1, list1, averageSalaryFrom));
        }
        return allTransfers;
    }
}
