package com.innotechnum.task1;


import com.innotechnum.task1.pojo.Department;
import com.innotechnum.task1.services.DepartmentService;
import com.innotechnum.task1.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;


public class Task {

    public static void main(String[] args) {

        List<Department> departmentList = new ArrayList<>();

        EmployeeService ems = new EmployeeService();

        if (args.length >= 2)
            departmentList = ems.readFromFile(args[0]);
        else
            System.out.println("Файл отсутствует");



        DepartmentService departmentService = new DepartmentService();
        if(departmentList != null)
        ems.writeInFile(args[1], departmentService.findTransfer(departmentList));


    }

}
