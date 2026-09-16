package jdbceexample;

import java.sql.*;

public class ViewEmployeeRecords {

    public static void main(String[] args) {

        // XAMPP MySQL connection details
        String url = "jdbc:mysql://localhost:3306/S104";
        String user = "root";
        String password = "";

        String query = "SELECT * FROM employees";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create Statement
            Statement stmt = conn.createStatement();

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("--- Employee Records ---");
            System.out.println("----------------------------------------");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.println(
                    "ID: " + id +
                    ", Name: " + name +
                    ", Department: " + department +
                    ", Salary: " + salary
                );
            }

            System.out.println("----------------------------------------");

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {

            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}