package com.mycompany.tinyta;

import java.util.Scanner;

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
//    
//    public static double addStudentSentiment()
//    {
//        
//    }
}
