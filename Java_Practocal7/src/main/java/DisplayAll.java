import java.sql.*;

public class DisplayAll {

    public static void main(String[] args) {

        // XAMPP MySQL connection details
        String url = "jdbc:mysql://localhost:3306/S104";
        String user = "root";
        String password = "";   // XAMPP default root password is usually empty

        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute SQL query
            String sql = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(sql);

            // 5. Display records
            System.out.println("Employee Records:");
            System.out.println("----------------------------------------");
            System.out.println("ID\tName\tDepartment\tSalary");
            System.out.println("----------------------------------------");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.println(
                    id + "\t" +
                    name + "\t" +
                    department + "\t" +
                    salary
                );
            }

            // 6. Close resources
            rs.close();
            stmt.close();
            con.close();

            System.out.println("----------------------------------------");
            System.out.println("Database connection closed.");

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}