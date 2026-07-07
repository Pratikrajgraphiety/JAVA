// Define the interface
interface Shape {
    double calculateArea();
    double calculatePerimeter();
}

// Implement the interface in Circle class
class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }
}

// Implement the interface in Rectangle class
class Rectangle implements Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Main class
public class ShapeInterfaceDemo {
    public static void main(String[] args) {

        Shape circle = new Circle(7);
        Shape rectangle = new Rectangle(10, 5);

        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

        System.out.println();

        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());
    }
}