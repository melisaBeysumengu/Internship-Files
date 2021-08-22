package Week1.Day1;

public class CityLists {
     public static void main(String[] args) {
         String[][] a = {
             {"İstanbul", "İzmir", "Ankara"},
             {"Beşiktaş", "Buca", "Kızılay"},
             {"Şişli", "Konak", "Çankaya"}
         };
         for (int i = 0; i < a.length; ++i) {
             System.out.print(a[0][i]+ ": ");
             for(int j = 1; j < a[i].length; ++j) {
                 System.out.print(a[j][i]+" ");
             }
             System.out.println();
         }
     }
 }
