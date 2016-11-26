package oop_programing;

public class Rectangle extends Shape {

    public Rectangle(float inWidth, float inHeight) {
        super(inWidth, inHeight);
        // TODO Auto-generated constructor stub
    }

    public float calculateSurface() {
        return width * height;
    }

    public String getShapeName() {
        return "Rectangle";
    }

    ;

}
