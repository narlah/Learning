package oop_programing;

public class Triangle extends Shape {

    public Triangle(float inWidth, float inHeight) {
        super(inWidth, inHeight);
    }

    public float calculateSurface() {
        return (width * height) / 2;
    }

    public String getShapeName() {
        return "Triangle";
    }

    ;

}
