package com.mycompany.practical_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Practical8B extends JFrame implements ActionListener {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/student_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // Default password in XAMPP is empty (""), or "root" in MySQL installer

    // GUI Form Components
    private JTextField txtRollNo;
    private JTextField txtName;
    private JComboBox<String> comboCourse;
    private JTextField txtMarks;
    private JButton btnSubmit;
    private JButton btnClear;
    private JLabel lblStatus;

    public Practical8B() {
        // Frame setup
        setTitle("Practical 8B: Student Record Submission (JDBC)");
        setSize(480, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Header Title
        JLabel lblHeader = new JLabel("Student Record Registration", JLabel.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 20));
        lblHeader.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        add(lblHeader, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 25, 10, 25),
                BorderFactory.createTitledBorder("Enter Student Details")
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);

        // Row 0: Roll No
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        JLabel lblRoll = new JLabel("Roll Number:");
        lblRoll.setFont(labelFont);
        formPanel.add(lblRoll, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtRollNo = new JTextField(15);
        txtRollNo.setFont(fieldFont);
        formPanel.add(txtRollNo, gbc);

        // Row 1: Student Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        JLabel lblName = new JLabel("Student Name:");
        lblName.setFont(labelFont);
        formPanel.add(lblName, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtName = new JTextField(15);
        txtName.setFont(fieldFont);
        formPanel.add(txtName, gbc);

        // Row 2: Course
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        JLabel lblCourse = new JLabel("Course / Branch:");
        lblCourse.setFont(labelFont);
        formPanel.add(lblCourse, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        String[] courses = {
            "Computer Science & Engineering",
            "Information Technology",
            "Electronics & Communication",
            "Mechanical Engineering",
            "Civil Engineering"
        };
        comboCourse = new JComboBox<>(courses);
        comboCourse.setFont(fieldFont);
        formPanel.add(comboCourse, gbc);

        // Row 3: Marks
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        JLabel lblMarks = new JLabel("Marks (%):");
        lblMarks.setFont(labelFont);
        formPanel.add(lblMarks, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtMarks = new JTextField(15);
        txtMarks.setFont(fieldFont);
        formPanel.add(txtMarks, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Bottom Panel: Buttons and Status
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 25, 15, 25));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        btnSubmit = new JButton("Submit Record");
        btnSubmit.setFont(new Font("Arial", Font.BOLD, 14));
        btnSubmit.setBackground(new Color(34, 139, 34));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFocusPainted(false);
        btnSubmit.addActionListener(this);

        btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Arial", Font.BOLD, 14));
        btnClear.setBackground(new Color(220, 53, 69));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFocusPainted(false);
        btnClear.addActionListener(this);

        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnClear);

        lblStatus = new JLabel("Ready to accept records", JLabel.CENTER);
        lblStatus.setFont(new Font("Arial", Font.ITALIC, 12));
        lblStatus.setForeground(Color.DARK_GRAY);

        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(lblStatus, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Initializes the database table if it doesn't already exist.
     */
    private void ensureTableExists(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS student ("
                + "roll_no INT PRIMARY KEY, "
                + "name VARCHAR(100) NOT NULL, "
                + "course VARCHAR(100) NOT NULL, "
                + "marks DOUBLE NOT NULL"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableSQL);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClear) {
            clearForm();
        } else if (e.getSource() == btnSubmit) {
            submitRecordToDatabase();
        }
    }

    private void clearForm() {
        txtRollNo.setText("");
        txtName.setText("");
        comboCourse.setSelectedIndex(0);
        txtMarks.setText("");
        lblStatus.setText("Form cleared.");
        lblStatus.setForeground(Color.DARK_GRAY);
        txtRollNo.requestFocus();
    }

    private void submitRecordToDatabase() {
        String rollStr = txtRollNo.getText().trim();
        String name = txtName.getText().trim();
        String course = (String) comboCourse.getSelectedItem();
        String marksStr = txtMarks.getText().trim();

        // 1. Validation: check empty fields
        if (rollStr.isEmpty() || name.isEmpty() || course == null || marksStr.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all fields before submitting!",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Validation: format checks
        int rollNo;
        double marks;
        try {
            rollNo = Integer.parseInt(rollStr);
            if (rollNo <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Roll number must be a positive integer!",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid Roll Number! Please enter a valid integer.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            marks = Double.parseDouble(marksStr);
            if (marks < 0 || marks > 100) {
                JOptionPane.showMessageDialog(this,
                        "Marks should be between 0 and 100!",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid Marks! Please enter a valid numeric value.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. JDBC Submission
        String insertSQL = "INSERT INTO student (roll_no, name, course, marks) VALUES (?, ?, ?, ?)";

        try {
            // Explicit driver loading (good practice for college practical compatibility)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,
                    "MySQL JDBC Driver not found!\nPlease ensure mysql-connector-j is included in your project dependencies.",
                    "Driver Error",
                    JOptionPane.ERROR_MESSAGE);
            lblStatus.setText("Error: JDBC Driver not found.");
            lblStatus.setForeground(Color.RED);
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Ensure table exists
            ensureTableExists(conn);

            // Execute Insert
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setInt(1, rollNo);
                pstmt.setString(2, name);
                pstmt.setString(3, course);
                pstmt.setDouble(4, marks);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this,
                            "Record submitted successfully to database!\n"
                            + "Roll No: " + rollNo + "\n"
                            + "Name: " + name + "\n"
                            + "Course: " + course + "\n"
                            + "Marks: " + marks,
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    lblStatus.setText("Record for Roll No " + rollNo + " submitted successfully.");
                    lblStatus.setForeground(new Color(34, 139, 34));
                    clearForm();
                }
            }
        } catch (SQLException ex) {
            // Handle duplicate primary key or general connection errors
            if (ex.getErrorCode() == 1062) { // MySQL error code for duplicate entry
                JOptionPane.showMessageDialog(this,
                        "A record with Roll No " + rollNo + " already exists in the database!",
                        "Duplicate Entry",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Database Error:\n" + ex.getMessage() + "\n\nTip: Check if MySQL server is running on localhost:3306.",
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            lblStatus.setText("Database error: " + ex.getMessage());
            lblStatus.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        // Set Look and Feel to System Default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> {
            new Practical8B().setVisible(true);
        });
    }
}
