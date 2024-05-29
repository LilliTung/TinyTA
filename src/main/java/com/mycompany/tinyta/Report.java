package com.mycompany.tinyta;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.io.File;

public class Report {
    private static ArrayList<String> words = new ArrayList<String>();
    private static ArrayList<Double> value = new ArrayList<Double>();
    // matching ArrayLists to hold corresponding words and sentiment values
    private static double reportSentiment;
    
    static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        words.add(temp[0]);
        value.add(Double.parseDouble(temp[1]));
        System.out.println(words);
        System.out.println(value);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
    
}
