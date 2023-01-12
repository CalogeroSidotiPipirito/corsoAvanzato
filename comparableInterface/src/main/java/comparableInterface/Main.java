package comparableInterface;

import java.lang.reflect.Array;
import java.util.Comparator;

public class Main{

    public static void main(String[] args) {

        Shape[] shapes = new Shape[6];
        shapes[0] = new Square(Name.SQUARE,  5);
        shapes[1] = new Square(Name.SQUARE, 3);
        shapes[2] = new Square(Name.SQUARE, 11);
        shapes[3] = new Triangle(Name.TRIANGLE, 5, 9);
        shapes[4] = new Triangle(Name.TRIANGLE, 2, 11);
        shapes[5] = new Triangle(Name.TRIANGLE,8, 7);

        areaOrder(shapes);

    }


    public static void areaOrder(Shape[] shapes){


        Shape temp;
        Double area1;
        int result, i, j;
        for ( i = 0; i < shapes.length; i++) {
            for ( j = 0; j < shapes.length; j++) {
                area1 = shapes[i].calculateArea();
                result = area1.compareTo(shapes[j].calculateArea());
                if (result == -1) {
                    temp = shapes[j];
                    shapes[j] = shapes[i];
                    shapes[i] = temp;

                }
            }
        }



        System.out.println("Area order: ");
        for (Shape s : shapes)
            System.out.print(s.getName() + " area " + s.getArea() + "\n");



    }

}
