package Week1.Day2.Example2;

public class Circle extends Shape{
    int radius;

    public Circle(int radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    double getArea(){
        return Math.PI*getRadius()*getRadius();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
