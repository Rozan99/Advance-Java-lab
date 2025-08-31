import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame implements ActionListener {
    JLabel nameLabel, emailLabel, passLabel;
    JTextField nameField, emailField;
    JPasswordField passField;
    JButton registerButton;

    RegistrationForm() {

        setTitle("Registration Form");


        setLayout(new GridLayout(4, 2, 4, 4));
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        passLabel = new JLabel("Password:");

        nameField = new JTextField();
        emailField = new JTextField();
        passField = new JPasswordField();

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);

        add(nameLabel);
        add(nameField);

        add(emailLabel);
        add(emailField);

        add(passLabel);
        add(passField);

        add(new JLabel());
        add(registerButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passField.getPassword());

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (name.length() < 3) {
            JOptionPane.showMessageDialog(this, "Name must be at least 3 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(this, "Invalid email format!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (password.length() < 6) {
            JOptionPane.showMessageDialog(this, "Password must be at least 6 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
