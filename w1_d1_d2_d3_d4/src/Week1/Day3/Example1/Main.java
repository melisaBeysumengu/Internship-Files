package Week1.Day3.Example1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String readFile1() throws IOException {

        FileInputStream fis = new FileInputStream("day3_example1_text.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String strLine = "";
        String temp = "";

        while ((strLine = br.readLine()) != null) {
            temp = temp + strLine.replaceAll("\\p{Punct}", "").toLowerCase(Locale.ROOT);
        }

        fis.close();
        return temp;
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());

        // Create a comparator code to sort the elements
        Comparator<Map.Entry<String, Integer>> myComparator = (e1, e2) -> e2.getValue().compareTo(e1.getValue());

        // Sort the list
        Collections.sort(list, myComparator);

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        Map<String, Integer> hashMap = new HashMap<>();

        String[] words = readFile1().split(" ");

        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        ArrayList<String> arl = new ArrayList<>(hashMap.keySet());
        Collections.sort(arl);

        for (int i = 0; i < arl.size(); i++) {
            System.out.print(arl.get(i) + "=" + hashMap.get(arl.get(i)) + "  ");
        }

        System.out.println("\n");

        Map<String, Integer> hm1 = sortByValue((HashMap<String, Integer>) hashMap);

        // print the sorted hashmap
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.print(en.getKey() + "=" + en.getValue() + "  ");
        }
    }

}
