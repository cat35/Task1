package com.innotechnum.task1.services;

import com.innotechnum.task1.pojo.Department;
import com.innotechnum.task1.pojo.Employees;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {

    public List<Department> readFromFile(String name) {
        Map<String, Department> map = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
            String s;
            while (bufferedReader.ready()) {
                s = bufferedReader.readLine();
                String[] arr = s.trim().split(";", 3);

                if (checkString(s)) {

                    if (!map.containsKey(arr[1])) {
                        map.put(arr[1], new Department(arr[1], new ArrayList<>()));
                    }
                    map.get(arr[1]).addEmployee(new Employees(arr[0], new BigDecimal(arr[2])));

                } else continue;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Файла не существует");
        }

        return new ArrayList<>(map.values());
    }

    public boolean checkString(String str) {
        String[] arr = str.trim().split(";", 3);
        if (arr.length != 3) {
            throw new ArrayIndexOutOfBoundsException();
        }
            if (arr[0].trim().equals("")) {
                System.out.println("отсутствует или неверно указано ФИО сотрудника");
                return false;
            }
            if (arr[1].trim().equals("")) {
                System.out.println("отсутствует или неверно указано название отдела");
                return false;
            }
            if (arr[2].trim().equals("") || !isDigit(arr[2]) || new BigDecimal(arr[2]).compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("неверный формат зарплаты");
                return false;
            }

        return true;
    }

    public boolean isDigit(String s) {
        if (s == null || s.isEmpty())
            return false;

        BigDecimal d;
       try{
          d = new BigDecimal(s);
       }
       catch (NumberFormatException e){
           return false;
       }
       return true;
    }

    public void writeInFile(String fileName, List<String> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            int count = 1;
            bufferedWriter.write("Варианты перевода");
            for (String s : list) {
                bufferedWriter.write("\nВариант № " + count + " " + s);
                count++;
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("Отсутствует имя файла");
        }
    }
}
