package jdbceexample;

import java.sql.*;
import java.util.Scanner;

public class SearchEmployeeById {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/S104";
        String user = "root";
        String password = "";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID to fetch: ");
        int employeeId = scanner.nextInt();

        String query = "SELECT * FROM employees WHERE id = ?";

        try {
            // MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to XAMPP MySQL
            Connection conn = DriverManager.getConnection(
                    url, user, password
            );

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, employeeId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.println("\nEmployee Details");
                System.out.println("-----------------------------");
                System.out.println("Employee ID : " + id);
                System.out.println("Name        : " + name);
                System.out.println("Department  : " + department);
                System.out.println("Salary      : " + salary);

            } else {

                System.out.println(
                    "No employee found with ID " + employeeId
                );
            }

            rs.close();
            stmt.close();
            conn.close();
            scanner.close();

        } catch (ClassNotFoundException e) {

            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}