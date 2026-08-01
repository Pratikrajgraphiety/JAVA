import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResumeForm extends JFrame implements ActionListener {

    JTextField txtName, txtEmail, txtPhone;
    JTextArea txtAddress;
    JRadioButton rbMale, rbFemale;
    JComboBox<String> cmbCourse;
    JCheckBox cbJava, cbPython, cbC, cbCpp;
    JButton btnSubmit, btnClear;
    ButtonGroup genderGroup;

    ResumeForm() {

        setTitle("Student Resume Form");
        setSize(550, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("STUDENT RESUME FORM", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblTitle, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Name"), gbc);

        gbc.gridx = 1;
        txtName = new JTextField();
        add(txtName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Email"), gbc);

        gbc.gridx = 1;
        txtEmail = new JTextField();
        add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Phone"), gbc);

        gbc.gridx = 1;
        txtPhone = new JTextField();
        add(txtPhone, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Address"), gbc);

        gbc.gridx = 1;
        txtAddress = new JTextArea(3, 20);
        add(new JScrollPane(txtAddress), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Gender"), gbc);

        JPanel genderPanel = new JPanel();
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");

        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);

        gbc.gridx = 1;
        add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Course"), gbc);

        gbc.gridx = 1;
        cmbCourse = new JComboBox<>();
        cmbCourse.addItem("B.Sc IT");
        cmbCourse.addItem("BCA");
        cmbCourse.addItem("B.Com");
        cmbCourse.addItem("FYCS");
        cmbCourse.addItem("SYCS");
        add(cmbCourse, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Skills"), gbc);

        JPanel skillPanel = new JPanel();
        cbJava = new JCheckBox("Java");
        cbPython = new JCheckBox("Python");
        cbC = new JCheckBox("C");
        cbCpp = new JCheckBox("C++");

        skillPanel.add(cbJava);
        skillPanel.add(cbPython);
        skillPanel.add(cbC);
        skillPanel.add(cbCpp);

        gbc.gridx = 1;
        add(skillPanel, gbc);

        JPanel buttonPanel = new JPanel();

btnSubmit = new JButton("Submit");
btnSubmit.setBackground(Color.BLUE);
btnSubmit.setForeground(Color.WHITE);

btnClear = new JButton("Clear");
btnClear.setBackground(Color.GREEN);
btnClear.setForeground(Color.WHITE);

        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);

        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnClear);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSubmit) {

            String gender = "";

            if (rbMale.isSelected())
                gender = "Male";
            else if (rbFemale.isSelected())
                gender = "Female";

            String skills = "";

            if (cbJava.isSelected())
                skills += "Java ";
            if (cbPython.isSelected())
                skills += "Python ";
            if (cbC.isSelected())
                skills += "C ";
            if (cbCpp.isSelected())
                skills += "C++ ";

            String message =
                    "I am : " + txtName.getText() +
                    "\nCourse : " + cmbCourse.getSelectedItem() +
                    "\nEmail : " + txtEmail.getText() +
                    "\nPhone : " + txtPhone.getText() +
                    "\nAddress : " + txtAddress.getText() +
                    "\nGender : " + gender +
                    "\nMy skills are : " + skills;

            JOptionPane.showMessageDialog(this, message);
        }

        if (e.getSource() == btnClear) {

            txtName.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            txtAddress.setText("");
            genderGroup.clearSelection();
            cmbCourse.setSelectedIndex(0);
            cbJava.setSelected(false);
            cbPython.setSelected(false);
            cbC.setSelected(false);
            cbCpp.setSelected(false);
        }
    }

    public static void main(String[] args) {
        ResumeForm resumeForm = new ResumeForm();
    }
}