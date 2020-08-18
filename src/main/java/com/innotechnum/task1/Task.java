package com.innotechnum.task1;


import com.innotechnum.task1.services.EmployeeService;



public class Task {

    public static void main(String[] args) {

        EmployeeService ems = new EmployeeService();

        if (args.length >= 2 )
            ems.readFromFile(args[0]);
        else
            System.out.println("Файл отсутствует");








    }

}
