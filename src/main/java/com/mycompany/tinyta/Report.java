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
    
    static
    {
        try 
        {
          Scanner file = new Scanner(new File("sentiments .txt"));
            while(file.hasNextLine())
            {
              String[] temp = file.nextLine().split(",");
              words.add(temp[0]);
              value.add(Double.parseDouble(temp[1]));
              System.out.println(words);
              System.out.println(value);
            }
          file.close();
        }
        catch(Exception e)
        {
          System.out.println("Error reading file");
        }
    }  
    
    public static double sentimentVal(String word)
    {
        for (int i=0; i<words.size(); i++)
        {
            if(words.get(i).equals(word))
            {
                return value.get(i);
            }
        }
        return 0;
    }
    
    public static double totalSentiment(String report)
    {
      String[] words = report.split(" ");
      for(String w : words)
      {
          reportSentiment += sentimentVal(w);
      }
      return reportSentiment;
    }
}
