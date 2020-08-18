package com.innotechnum.task1.services;

import com.innotechnum.task1.pojo.Department;
import com.innotechnum.task1.pojo.Employees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeService {


    public static Map<String, Department> map = new HashMap<>();

    public void readFromFile(String name) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
            String s;
            while (bufferedReader.ready()) {
                s = bufferedReader.readLine();
                if (checkString(s)) {
                    String[] arr = s.trim().split(";", 3);
                    if (!map.containsKey(arr[1])) {
                        map.put(arr[1], new Department(arr[1], new ArrayList<>()));
                    }
                    map.get(arr[1]).addEmployee(new Employees(arr[0], new BigDecimal(arr[2])));

                } else break;


            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Файла не существует");
        }
    }

    public boolean checkString(String str) {
        String[] arr = str.trim().split(";", 3);
        if (arr.length >= 3) {
            if (arr[0].equals("")) {
                System.out.println("отсутствует или неверно указано ФИО сотрудника");
                return false;
            }
            if (arr[1].equals("")) {
                System.out.println("отсутствует или неверно указано название отдела");
                return false;
            }
            if (arr[2].equals("") || !isDigit(arr[2]) || new BigDecimal(arr[2]).compareTo(BigDecimal.valueOf(0)) < 0) {
                System.out.println("неверный формат зарплаты");
                return false;
            }
        }
        return true;


    }

    public boolean isDigit(String s) {
        if(s == null || s.isEmpty())
            return false;
        for(int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }
}
