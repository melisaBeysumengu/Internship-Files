package Week1.Day1;

import java.util.Scanner;

public class Grade {

     public static void main(String[] args) throws Exception {
         Scanner s = new Scanner(System.in);

         int input = 0;
         double sum = 0;
         int counter = 0;

         System.out.print("Enter grades: ");

         while(input!=101){
             input = s.nextInt();
             if(input != 101){
                 sum += input;
                 counter++;
             }
             if(input >101)
                 System.out.println("numbers must be lower than 100");
             if(input < 0)
                 System.out.println("numbers must be greater than 0");
         }
         System.out.println("Average is: " + sum/counter);
     }
 }
