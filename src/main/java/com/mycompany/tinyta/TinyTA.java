package com.mycompany.tinyta;

import java.util.Scanner;
import java.util.ArrayList;

public class TinyTA {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int numStudents;
        String temp; 
        ArrayList<String> reports = new ArrayList<String>();
        
        System.out.println("How many students are in this group?");
        numStudents = input.nextInt();
        
        for(int i=0; i<=numStudents; i++)
        {
            //temp = input.nextLine();
            System.out.println("input report (1 PARAGRAPH ONLY):");
            temp = input.nextLine();
            reports.add(i,temp);
        }
        System.out.println(reports.toString());
        
        
    }
    
}
