package fr.epita.geometry.tests;

import fr.epita.geometry.datamodel.Triangle;

public class TestTriangle {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(100.0, 10.0, 2.0, 2.0);

        System.out.println(triangle.getArea());
        //area should be 500

        System.out.println(triangle.getPerimeter());
        //perimeter should be 104
    }
}
