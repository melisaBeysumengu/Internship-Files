package Week1.Day3.Example2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String address;
    private List<Pair<String, Double>> grade;
    private transient double cumulativeGpa;

    public Student(int id, String name, String surname, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.grade = new ArrayList<>();
        calculateCumulativeGpa();
    }

    public void addGrade(String courseId, double grade) {
        this.grade.add(new Pair<String, Double>(courseId, grade));
        System.out.println("Grade couldn't added!!!");
    }

    private void readObject(ObjectInputStream serialized) throws ClassNotFoundException, IOException {
        serialized.defaultReadObject();
        calculateCumulativeGpa();
    }

    void calculateCumulativeGpa() {
        double sum = 0;
        for (Pair<String, Double> stringDoublePair : grade) {
            sum += stringDoublePair.second;
        }
        this.cumulativeGpa = sum / grade.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Pair<String, Double>> getGrade() {
        return grade;
    }

    public double getCumulativeGpa() {
        return cumulativeGpa;
    }

    public void setCumulativeGpa(double cumulativeGpa) {
        this.cumulativeGpa = cumulativeGpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", cumulativeGpa=" + cumulativeGpa +
                '}';
    }
}
