package com.innotechnum.task1.services;

import com.innotechnum.task1.pojo.Employees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {


    Map<String, List<Employees>> map = new HashMap<>();

    public void readFromFile(String name) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
            String s;
            while (bufferedReader.ready()) {
                s = bufferedReader.readLine();
                checkString(s);
                String[] arr = s.trim().split(";", 3);
                if (map.get(arr[1])==null){
                    List<Employees> list = new ArrayList<Employees>();
                    list.add(new Employees(arr[0], new BigDecimal(arr[2])));
                    map.put(arr[1], list);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Файла не существует");
        }
    }

    public void checkString(String str) {
        String[] arr = str.trim().split(";",3);
        if(arr.length >= 3) {
            if (arr[0].equals(""))
                System.out.println("отсутствует или неверно указано ФИО сотрудника");
            if (arr[1].equals(""))
                System.out.println("отсутствует или неверно указано название отдела");
            if (arr[2].equals("") || !isDigit(arr[2]) || Double.parseDouble(arr[2]) < 0)
                System.out.println("неверный формат зарплаты");
        }


    }

    public boolean isDigit(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
