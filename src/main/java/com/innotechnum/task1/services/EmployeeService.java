package com.innotechnum.task1.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeService{


    ArrayList<String> list = new ArrayList<>();

    public void readFromFile(String name) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(name))){
            String s;
            while(bufferedReader.ready()){
                s = bufferedReader.readLine();
                String[] mas = s.split(" ");
                list.add(s);

                if (mas[0].equals("")&&mas[1].equals("")&&mas[2].equals(""))
                    throw new IllegalArgumentException();
                else if(mas[3].equals(""))
                    throw new IllegalArgumentException();
                else if (mas[4].equals(""))
                            throw new IllegalArgumentException();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
