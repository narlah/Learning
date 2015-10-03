package oop_programing;


public class Circle extends Shape {
	public Circle(float inWidth, float inHeight)  {
		super(inWidth, inHeight);
		if (inHeight != inWidth) {
			System.out.println("Not a circle!");
		}
	}

	public float calculateSurface() {
		return (float) (2 * Math.PI * height * width);
	}
	public String getShapeName(){return "Circle";};

}
