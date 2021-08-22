public class Employee {
    int id;
    String name;
    String surname;
    String title;
    int birthYear;

    public Employee(int id, String name, String surname, String title, int birthYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.birthYear = birthYear;
    }

    public Employee(String name, String surname, String title){
        this.name = name;
        this.surname = surname;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
