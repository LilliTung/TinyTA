package com.mycompany.tinyta;

import java.util.Scanner;
import java.util.ArrayList;

public class TinyTA {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int numStudents;
        ArrayList<String> reports = new ArrayList<>();
        ArrayList<Double> reportSentiment = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<Double> studentSentiment = new ArrayList<>();
        ArrayList<Double> avgSentiment = new ArrayList<>();
        ArrayList<String> gradeRecommendation = new ArrayList<>();
        ArrayList<Integer> wordCounts = new ArrayList<>(); // To store word counts

        System.out.println("How many students are in this group?");
        numStudents = input.nextInt();
        numStudents = numStudents * (numStudents - 1); // Adjust the number of reports expected
        input.nextLine(); // Clear scanner

        String[][] fullName = new String[numStudents][2];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Person Evaluating: ");
            System.out.println("First name: ");
            String evaluatorFirstName = input.next();
            System.out.println("Last name: ");
            String evaluatorLastName = input.next();
            input.nextLine(); // Clear scanner
            System.out.println("Person Being Evaluated: ");
            String firstName = Student.getFirstName();
            firstNames.add(firstName);
            String lastName = Student.getLastName();
            lastNames.add(lastName);
            //input.nextLine(); // Clear scanner

            System.out.println("Input report (1 PARAGRAPH ONLY):");
            String temp = input.nextLine();
            reports.add(temp);

            // Calculate and store sentiment value
            double sentiment = Report.totalSentiment(temp);
            reportSentiment.add(sentiment);

            // Calculate and store word count
            int wordCount = countWords(temp);
            wordCounts.add(wordCount);
            
            // Calculate and store sentiment/wordCount, as well as suggested grade
            if(sentiment!=0)
            {
                double avg = wordCount/sentiment;
                avgSentiment.add(avg);
                String grade = gradeRecommendation(avg);
                gradeRecommendation.add(grade);
            }
            else
            {
                avgSentiment.add(sentiment);
                String grade = gradeRecommendation(sentiment);
                gradeRecommendation.add(grade);
            }
                        
            System.out.println();
        }
      
        for (int j = 0; j < firstNames.size(); j++) {
            boolean contains = false;
            for (int k = 0; k < numStudents; k++) {
                if (firstNames.get(j).equals(fullName[k][0]) && lastNames.get(j).equals(fullName[k][1])) {
                    contains = true;
                }
            }

            if (!contains) {
                String fullNameStr = firstNames.get(j) + " " + lastNames.get(j);
                double sentiment = Student.addStudentSentiment(firstNames, lastNames, reportSentiment, fullNameStr);
                studentSentiment.add(sentiment);
                fullName[j][0] = firstNames.get(j);
                fullName[j][1] = lastNames.get(j);
            }
        }

        // Output results
        System.out.println("Reports: " + reports.toString());
        System.out.println("First Names: " + firstNames.toString());
        System.out.println("Last Names: " + lastNames.toString());
        System.out.println("Report Sentiments: " + reportSentiment.toString());
        System.out.println("Student Sentiments: " + studentSentiment.toString());
        System.out.println("Word Counts: " + wordCounts.toString());
        System.out.println("Sentiment/Word Count: " + avgSentiment.toString());
        System.out.println("Recommended Grade: " + gradeRecommendation.toString());
    }

    // Method to count words in a given string
    public static int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        String[] words = input.trim().split("\\s+");
        return words.length;
    }
    
    public static String gradeRecommendation(double sentiment)
    {
        if (sentiment>10)
        {
            return "90-100";
        }
        else if (sentiment>=5 && sentiment <10)
        {
            return "80-89";
        }
        else if (sentiment>=0 && sentiment <5)
        {
            return "70-79";
        }
        else if (sentiment>=-5 && sentiment <0)
        {
            return "60-69";
        }
        else if (sentiment>=-10 && sentiment<-5)
        {
            return "50-59";
        }
        else
        {
            return "0-49";
        }
    }
} 
