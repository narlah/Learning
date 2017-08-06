package oop_programing;

class Triangle extends Shape {

    Triangle(float inWidth, float inHeight) {
        super(inWidth, inHeight);
    }

    public float calculateSurface() {
        return (width * height) / 2;
    }

    public String getShapeName() {
        return "Triangle";
    }

}
