package com.innotechnum.task1;

import com.innotechnum.task1.services.EmployeeService;

public class Task {

    public static void main(String[] args) {

        EmployeeService ems = new EmployeeService();
        ems.readFromFile(args[0]);


    }

}
