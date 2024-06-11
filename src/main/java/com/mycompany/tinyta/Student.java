package com.mycompany.tinyta;

import java.util.Scanner;
import java.util.ArrayList;

public class Student 
{
    private static String firstName;
    private static String lastName;
    private static double studentSentiment;
    private static Scanner input = new Scanner(System.in);
    
    public static String getFirstName()
    {
        System.out.println("First name: ");
        firstName = input.next();
        return firstName;
    }
    
    public static String getLastName()
    {
        System.out.println("Last name: ");
        lastName = input.next();
        return lastName;
    }
    
    public static double addStudentSentiment(ArrayList<String>firstNames, 
            ArrayList<String>lastNames, ArrayList<Double> reportSentiment, String name)
   {
       String[] temp = name.split(" ");
       for(int i =0;i<firstNames.size(); i++) 
       {
           if(firstNames.get(i).equals(temp[0]) && lastNames.get(i).equals(temp[1]))
           {
               studentSentiment += reportSentiment.get(i);
           }
       }
       return studentSentiment;
   }
}
