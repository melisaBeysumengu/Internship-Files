package Week1.Day3.Example2;

import java.io.*;
import java.util.*;

public class Main {

    static void readFile() {
        try {
            FileInputStream fis = new FileInputStream("day3_example2_Student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Student> student = (ArrayList<Student>) ois.readObject();

            for (int i = 0; i < student.size(); i++) {
                System.out.println(student.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeFile(ArrayList<Student> student) {
        try {
            FileOutputStream fos = new FileOutputStream("day3_example2_Student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //new List.add(new Pair<String, Double>("1",40.0))
        ArrayList<Student> s = new ArrayList<>();
        s.add(new Student(1, "Ali", "Veli", "Istanbul"));
        s.add(new Student(2, "Ayşe", "Deli", "İzmir"));
        s.add(new Student(3, "Fatma", "Veli", "Istanbul"));
        s.add(new Student(4, "Mustafa", "Veli", "Istanbul"));
        s.add(new Student(5, "Semih", "Veli", "Ankara"));
        s.add(new Student(6, "İlke", "Veli", "Istanbul"));
        s.add(new Student(7, "Tümay", "Veli", "Adana"));
        s.add(new Student(8, "Batuhan", "Veli", "Istanbul"));
        s.add(new Student(9, "İrem", "Veli", "Manisa"));
        s.add(new Student(10, "Mehmet", "Veli", "Istanbul"));

        for (int i = 0; i < s.size(); i++) {
            s.get(i).addGrade("ASD", i);
            s.get(i).addGrade("DFA", i+20);
            s.get(i).addGrade("ACD", i+40);
        }

        writeFile(s);
        readFile();


    }


}
