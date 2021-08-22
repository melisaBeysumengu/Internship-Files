package Week1.Day2.Example2;

public class Main {
    public static void main(String[] args) {
        Pen p = new Pen();

        Rectangle r = new Rectangle(12,13,"green");
        Circle c = new Circle(5,"red");

        p.draw(c);
        p.draw(r);

        p.changeColor("purple",r);
        p.changeColor("blue", c);

        p.draw(c);
        p.draw(r);
    }
}
