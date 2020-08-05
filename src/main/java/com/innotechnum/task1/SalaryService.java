package com.innotechnum.task1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SalaryService implements ReadFile{

    ArrayList<Double> salaries = new ArrayList<>();
    @Override
    public void readFromFile() {
        try(Scanner sc = new Scanner(new File("task1.txt"))){

            while(sc.hasNextDouble()){
                salaries.add(sc.nextDouble());
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
