import java.util.Scanner;

public class ResumeCMD {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("S104 Pratik");
            
            System.out.println("S104 Pratik STUDENT RESUME\n");
            
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Enter Gender: ");
            String gender = sc.nextLine();
            
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            
            System.out.print("Enter Mobile Number: ");
            String mobile = sc.nextLine();
            
            System.out.print("Enter Address: ");
            String address = sc.nextLine();
            
            System.out.print("Enter Course: ");
            String course = sc.nextLine();
            
            System.out.print("Enter College Name: ");
            String college = sc.nextLine();
            
            System.out.print("Enter Skills (comma separated): ");
            String skills = sc.nextLine();
            
            System.out.print("Enter Hobbies: ");
            String hobbies = sc.nextLine();
            
            System.out.println("\n S104 Prstik");
            System.out.println("         STUDENT RESUME");
            System.out.println("Name      : " + name);
            System.out.println("Age       : " + age);
            System.out.println("Gender    : " + gender);
            System.out.println("Email     : " + email);
            System.out.println("Mobile    : " + mobile);
            System.out.println("Address   : " + address);
            System.out.println("Course    : " + course);
            System.out.println("College   : " + college);
            System.out.println("Skills    : " + skills);
            System.out.println("Hobbies   : " + hobbies);
            System.out.println("====================================");
        }
    }
}