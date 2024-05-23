package com.mycompany.tinyta;

import java.util.Scanner;
import java.util.ArrayList;

public class TinyTA {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int numStudents;
        //String temp;
        
        System.out.println("How many students are in this group?");
        numStudents = input.nextInt();
        String[] reports = new String[numStudents];
        
        //for(int i=0; i<numStudents; i++)
        //{
            //temp = input.nextLine();
            System.out.println("input report (1 PARAGRAPH ONLY):");
            reports[1] = input.nextLine();
        //}
        System.out.println(reports.toString());
        
        
    }
    
}
