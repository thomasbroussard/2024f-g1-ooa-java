package fr.epita.geometry.datamodel;

public class Square implements Shape{
    Double side;
    public Square(Double v) {
        this.side = v;
    }

    public Double getSide() {
        return side;
    }

    public void setSide(Double side) {
        this.side = side;
    }

    public Double getArea(){
        return this.side * this.side;
    }

    @Override
    public Double getPerimeter() {
        return this.side * 4;
    }
}
