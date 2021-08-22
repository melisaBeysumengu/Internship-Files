package Week1.Day1;

import java.util.Scanner;

 public class App {
     public static void main(String[] args) throws Exception {
         System.out.print("Enter grades: ");
        
         Scanner s = new Scanner(System.in);
         int input = 0;

         System.out.print("Enter age: ");
         input = s.nextInt();

         if(input <22)
         System.out.println("young");
         else System.out.println("old");
     }
 }
