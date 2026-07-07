// Abstract class
abstract class Animal {

    // Abstract method (no body)
    abstract void sound();

    // Concrete method
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Subclass Dog
class Dog extends Animal {

    // Implementing abstract method
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Subclass Cat
class Cat extends Animal {

    // Implementing abstract method
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

// Main class
public class Abstractmethod {

    public static void main(String[] args) {

        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.sound();
        dog.eat();

        cat.sound();
        cat.eat();
    }
}