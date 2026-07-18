// Define a custom exception class
class CustomException extends Exception {
public CustomException(String message) {
super(message);
}
}

// Create a class that uses the custom exception
class ExceptionDemo {
public void performTask(int value) throws CustomException {
if (value < 0) {
throw new CustomException("Value cannot be negative");
} else if (value > 100) {
throw new CustomException("Value cannot exceed 100");
} else {
System.out.println("Task performed successfully");
}
}

}

public class CODE2 {
public static void main(String[] args) {
ExceptionDemo demo = new ExceptionDemo();

try {
demo.performTask(50); // No exception will be raised
demo.performTask(-10); // CustomException will be raised
demo.performTask(120); // CustomException will be raised
} catch (CustomException e) {
System.out.println("Custom Exception Caught: " + e.getMessage());
}
}
}