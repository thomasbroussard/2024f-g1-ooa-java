package fr.epita.geometry.tests;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Shape;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;

import java.util.List;

public class TestComputeTotalArea {

    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(100d, 10d, 5d,5d);
        Triangle triangle2 = new Triangle(100d, 12d, 5d,5d);
        Triangle triangle3 = new Triangle(100d, 14d, 5d,5d);

        double totalArea = triangle1.getArea() + triangle2.getArea() + triangle3.getArea();

        Circle circle1 = new Circle(10d);
        Circle circle2 = new Circle(12d);
        Circle circle3 = new Circle(14d);

        totalArea = totalArea + circle1.getArea() + circle2.getArea() + circle3.getArea();

        Shape square1 = new Square(10.0);

        //type casting
        Square squareCasting = (Square) square1;

        List<Shape> listOfShapes = List.of(circle1, triangle1, square1);
        totalArea = 0;

        for (Shape s: listOfShapes){
            totalArea +=   s.getArea();
        }


    }
}
