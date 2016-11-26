package oop_programing;

public class TestShape {
    public static void main(String[] args) {
        Shape[] data = new Shape[10];
        ;
        try {
            data[0] = (new Rectangle(3, 2));
            data[1] = (new Triangle(2, 1));
            data[2] = (new Rectangle(3, 2));
            data[3] = (new Circle(4, 4));
            data[4] = (new Triangle(2, 1));

            data[5] = (new Triangle(2, 1));
            data[6] = (new Triangle(2, 1));
            data[7] = (new Circle(4, 4));
            data[8] = (new Circle(4, 4));
            data[9] = (new Rectangle(3, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Surface for %s Shape is %f\n", data[i].getShapeName(), data[i]
                    .calculateSurface());
        }

    }

}
