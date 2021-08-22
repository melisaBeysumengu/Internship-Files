package Week1.Day2.Example2;

public abstract class Shape {
    String color;
    abstract double getArea();

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
