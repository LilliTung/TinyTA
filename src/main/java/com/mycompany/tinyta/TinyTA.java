package com.mycompany.tinyta;

import java.util.Scanner;
import java.util.ArrayList;

public class TinyTA {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int numStudents;
        ArrayList<String> reports = new ArrayList<String>();
        ArrayList<Double> reportSentiment = new ArrayList<Double>();
        ArrayList<String> firstNames = new ArrayList<String>();
        ArrayList<String> lastNames = new ArrayList<String>();
        ArrayList<Double> studentSentiment = new ArrayList<Double>();
        String temp; 
        
        System.out.println("How many students are in this group?");
        numStudents = input.nextInt();
        numStudents = (int) (numStudents*(numStudents-1));
        input.nextLine(); //clear scanner
        
        String[][]  fullName = new String[numStudents][2];
        
        for(int i=0; i<numStudents; i++)
        {
            System.out.println("Person Evaluating: ");
            System.out.println("First name: ");
            input.next();
            System.out.println("Last name: ");
            input.next();
            System.out.println("Person Being Evaluated: ");
            firstNames.add(i,Student.getFirstName());
            // get and store student first name
            lastNames.add(i,Student.getLastName());
            // get and store student last name
            input.nextLine();
            // clear scanner
            System.out.println("input report (1 PARAGRAPH ONLY):");
            temp = input.nextLine();
            reports.add(i,temp);
            reportSentiment.add(i,Report.totalSentiment(temp));
            // get and store report
            System.out.println();
        }
        
        for(int j=0; j<firstNames.size(); j++)
        {
            boolean contains = false;
            for(int k=0;k<numStudents; k++)
            {
                if(firstNames.get(j).equals(fullName[k][0]) && lastNames.get(j).equals(fullName[k][1]))
                {
                  contains = true;
                }
            }
            
            if(!contains)
            {
                studentSentiment.add(Student.addStudentSentiment(firstNames, lastNames, reportSentiment, firstNames.get(j)+" "+lastNames.get(j)));
                fullName[j][0] = firstNames.get(j);
                fullName[j][1] = lastNames.get(j);
            }
           // this method needs to send each name (in the format first name + " " + last name) ONCE to the 
           // addStudentSentiment method in the Student class
           // and then add the return from that method to the studentSentiment ArrayList
           // this method should also fill the 2D array "fullName" with the first and last names 
           //(NO REPEATS)
           //overall this method is storing the overall student sentiment along with their names 
           //containing no repeated names
        }
        
        //lastly need to take the student sentiment and recommend a grade range for that student's
        //teamwork based on their peer's evaluation of their contributions
        System.out.println(reports.toString());
        System.out.println(firstNames.toString());
        System.out.println(lastNames.toString());
        System.out.println(reportSentiment.toString());
        System.out.println(studentSentiment);
        
    }
    
}
