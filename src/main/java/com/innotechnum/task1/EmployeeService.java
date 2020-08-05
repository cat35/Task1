package com.innotechnum.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeService implements ReadFile{


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
