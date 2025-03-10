package fr.epita.geometry.datamodel;

public class Circle implements Shape {

    private Double radius;

    public Circle(){

    }

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public Double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }
}
