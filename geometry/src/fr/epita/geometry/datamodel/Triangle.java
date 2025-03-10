package fr.epita.geometry.datamodel;

public class Triangle implements Shape{

    private Double base;
    private Double height;
    private Double sideA;
    private Double sideB;

    public Triangle(Double base, Double height, Double sideA, Double sideB) {
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
    }
    public Triangle(Integer base, Integer height, Integer sideA, Integer sideB) {
        this.base = base.doubleValue();
        this.height = height.doubleValue();
        this.sideA = sideA.doubleValue();
        this.sideB = sideB.doubleValue();
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getSideA() {
        return sideA;
    }

    public void setSideA(Double sideA) {
        this.sideA = sideA;
    }

    public Double getSideB() {
        return sideB;
    }

    public void setSideB(Double sideB) {
        this.sideB = sideB;
    }

    public Double getArea(){
       return this.base * this.height / 2;
    }

    public Double getPerimeter(){
        return this.base + this.sideA + this.sideB;
    }
}
