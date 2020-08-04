package com.innotechnum.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Employees implements ReadFile {

    private String name;

    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employees(String name, String department) {
        this.name = name;
        this.department = department;
    }

    ArrayList<String> list = new ArrayList<>();

    @Override
    public void readFromFile() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("task1.txt"))){
            String s;
            while(bufferedReader.ready()){
                s = bufferedReader.readLine();
                list.add(s);

                if (s == null)
                    break;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
