package Week1.Day2.Example2;

public class Pen {
    void draw(Shape s){
        System.out.println("Area is: "+s.getArea());
        System.out.println(" Color is: "+s.getColor());
    }
    void changeColor(String color, Shape s){
        s.setColor(color);
    }
}
