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
            int count = 0;
            while (bufferedReader.ready()) {
                s = bufferedReader.readLine();
                count++;
                String[] arr = s.trim().split(";", 3);

                if (checkString(s,count)) {

                    if (!map.containsKey(arr[1])) {
                        map.put(arr[1], new Department(arr[1], new ArrayList<>()));
                    }

                    map.get(arr[1]).addEmployee(new Employees(arr[0], new BigDecimal(arr[2].trim())));

                } else continue;

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Файла не существует");
        }

        return new ArrayList<>(map.values());
    }

    public boolean checkString(String str, int m) {


        String[] arr = str.trim().split(";", 3);



            if (arr.length != 3) {
                System.out.printf("Строка под номером %d является пустой \n", m);
                return false;
            }

            if (arr[0].trim().equals("")) {
                System.out.printf("отсутствует или неверно указано ФИО сотрудника в строке %d \n", m);
                return false;
            }
            if (arr[1].trim().equals("")) {
                System.out.printf("отсутствует или неверно указано название отдела в строке %d \n", m);
                return false;
            }
            if (arr[2].trim().equals("") || !isDigit(arr[2].trim()) || new BigDecimal(arr[2].trim()).compareTo(BigDecimal.ZERO) < 0) {
                System.out.printf("неверный формат зарплаты в строке %d \n", m);
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
