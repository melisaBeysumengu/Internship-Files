package Week1.Day1;

public class Array {

     static int[] reverse(int array[]){
         int[] b = new int[array.length];
         int j = array.length;
         for (int i = 0; i < array.length; i++) {
             b[j - 1] = array[i];
             j = j - 1;
         }
         return b;
     }

     static void print(int array[]){
         for (int k = 0; k < array.length; k++) {
             System.out.print(array[k]+ " ");
         }
         System.out.println();
     }

     public static void main(String[] args){
         int [] array = {10, 20, 30, 40, 50};
         System.out.println("Original array:");
         print(array);
         array = reverse(array);
         System.out.println("Reversed array:");
         print(array);
     }
 }
