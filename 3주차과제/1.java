public class Shape {
    public double area;

    public double calculateArea() { return this.area; }
}

public class Rectangle extends Shape {
    public double length;
    public double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        this.area = this.length*this.width;
    }

}

public class Circle extends Shape {
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
        this.area = (22/7)*this.radius*this.radius;
    }
    
}

public class AreaCalculator{
    public double calculateArea(Shape shape){ 
        return shape.calculateArea();
    }
}
