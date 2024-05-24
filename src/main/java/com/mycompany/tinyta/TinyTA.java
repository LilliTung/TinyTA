package com.mycompany.tinyta;

import java.util.Scanner;
import java.util.ArrayList;

public class TinyTA {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int numStudents;
        ArrayList<String> reports = new ArrayList<String>();
        ArrayList<String> firstName = new ArrayList<String>();
        ArrayList<String> lastName = new ArrayList<String>();
        String temp; 
        
        System.out.println("How many students are in this group?");
        numStudents = input.nextInt();
        input.nextLine(); //clear scanner
        
        for(int i=0; i<numStudents; i++)
        {
            System.out.println("input report (1 PARAGRAPH ONLY):");
            temp = input.nextLine();
            reports.add(i,temp);
            // get and store report
            System.out.println("\nWho was this report about?");
            firstName.add(i,Student.getFirstName());
            // get and store student first name
            lastName.add(i,Student.getLastName());
            // get and store student last name
            System.out.println();
        }
        System.out.println(reports.toString());
        System.out.println(firstName.toString());
        System.out.println(lastName.toString());
        
        
    }
    
}
