class Student {
    String name;
    int age;

    // Default Constructor
    Student() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized Constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }

    // Method Overloading
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    void display(String course) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }

    // Static Method
    static void collegeName() {
        System.out.println("College: ABC College");
    }

    public static void main(String[] args) {
        Student.collegeName();

        Student s1 = new Student();
        s1.display();

        Student s2 = new Student("Rahul", 20);
        s2.display("BCA");
    }
}
