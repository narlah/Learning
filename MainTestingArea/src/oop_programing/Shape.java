package oop_programing;

public abstract class Shape {
	float width;
	float height;


	public Shape(float inWidth, float inHeight) {
		this.width = inWidth;
		this.height = inHeight;
	}

	public abstract float calculateSurface();
	public abstract String getShapeName();
}
