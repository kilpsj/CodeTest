/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codetest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;
import java.util.Scanner; 

/**
 * This program will prompt the user to give a file path of their specified 
 * CSV file. The program will compute and output the mean, median, sum, minimum, 
 * maximum and standard deviation of each line from the inputted file.
 * @author Jim Kilps
 */
public class CodeTest {
    /**
     * @param args filename, numbers[], sum, minValue, maxValue, average,
     * StandardDeviation
     * 
     */
    public static void main(String[] args) 
            throws FileNotFoundException, IOException {
        String st = null;
        int LineNum = 0;
        double[] numbers = null;
        String filename=  JOptionPane.showInputDialog(null,"Enter File Path:");
        File file = new File(filename);
        BufferedReader br= new BufferedReader(new FileReader(file));
        while ((st = br.readLine()) != null){
            LineNum++;
            String[] ar=st.split(",");
            numbers = new double[ar.length]; 
                for (int i = 0; i < ar.length; i++){
                    numbers[i] = Double.parseDouble(ar[i]);
                }   
            System.out.println("Mean of line "+ LineNum + "=" + mean(numbers));                
            System.out.println("Median of line "+ LineNum + "=" 
                    + median(numbers));
            System.out.println("Sum of line "+ LineNum + "=" + sum(numbers));
            System.out.println("Minimum of line "+ LineNum + "=" 
                    + min(numbers));
            System.out.println("Maximum of line "+ LineNum + "=" 
                    + max(numbers));
            System.out.println("Standard Deviation of line " + LineNum 
                    + "=" + StandardDeviation(numbers));
        }
        
        
    }
    /**
    mean() will compute the sum of an array of numbers and return the
    * mean of those numbers.
    */
    public static double mean(double[] m) {
    double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i];
        }
    return sum / m.length;
}
    /**
    median() sorts the array of numbers and return the median of the array.
    */
    public static double median(double[] m) {
    Arrays.sort(m);
    int middle = m.length/2;
        if (m.length%2 == 1) {
            return m[middle];
        } 
        else {
            return (m[middle-1] + m[middle]) / 2.0;
        }
    }    
    /**
    sum() computes the sum of an array and returns the sum.
    */
    public static double sum(double[] m) {
    double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i];
            }
    return sum;   
    }
    /**
    max() finds the max value of an array of numbers and returns that max value
    */
    public static double max(double[] m) {
    double maxValue = m[0];
        for (int i = 1; i < m.length; i++) {
            if (m[i] > maxValue) {
                maxValue = m[i];
            }
        }
    return maxValue;
    }
    /**
    min() finds the min value of an array of numbers and returns that min value
    */
    public static double min(double[] m) {
    double minValue = m[0];
        for (int i = 1; i < m.length; i++) {
            if (m[i] < minValue) {
                minValue = m[i];
                }
            }
    return minValue;
    }
    /**
    StandardDeviation() computes the sum and average from the array given. It
    * computes and returns the standard deviation from those values.
    */
    public static double StandardDeviation(double[] m) {
    double sd = 0;
    double sum = sum(m);
    double average = sum / m.length;
        for (int i = 0; i < m.length; i++) {
         sd += ((m[i] - average)*(m[i] - average)) / (m.length - 1);
            }
    double standardDeviation = Math.sqrt(sd);
    return standardDeviation;
    }
}
