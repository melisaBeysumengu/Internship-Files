package Week1.Day2.Example2;

public class Rectangle extends Shape{
    int width;
    int height;

    public Rectangle(int width, int height, String color) {
        super(color);
        this.height = height;
        this.width = width;
    }

    @Override
    double getArea(){
        return getWidth()*getHeight();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
