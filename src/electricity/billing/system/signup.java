package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class signup extends JFrame implements ActionListener {
    Choice loginaschoice;
    JTextField meternumberField, employeeField, usernameField,nameField, passwordField;
    JButton createButton, backButton;
    signup(){
        super("Sign Up");
        getContentPane().setBackground(new Color(168, 204, 255));

        JLabel createAs= new JLabel("Create Account as");
        createAs.setBounds(30, 60, 125, 20);
        add(createAs);

        loginaschoice = new Choice();
        loginaschoice.add("Admin");
        loginaschoice.add("Customer");
        loginaschoice.setBounds(170, 50, 120, 20);
        add(loginaschoice);


        JLabel meternumber= new JLabel("Meternumber");
        meternumber.setBounds(30, 100, 125, 20);
        meternumber.setVisible(false);
        add(meternumber);

        meternumberField= new JTextField();
        meternumberField.setBounds(170, 100, 120, 20);
        meternumberField.setVisible(false);
        add(meternumberField);


        JLabel employer= new JLabel("Employee id");
        employer.setBounds(30, 100, 125, 20);
        employer.setVisible(true);
        add(employer);

        employeeField= new JTextField();
        employeeField.setBounds(170, 100, 125, 20);
        employeeField.setVisible(true);
        add(employeeField);

        JLabel username= new JLabel("Username");
        username.setBounds(30, 140, 125, 20);
        add(username);

        usernameField= new JTextField();
        usernameField.setBounds(170, 140, 125, 20);
        add(usernameField);

        JLabel name= new JLabel("Name");
        name.setBounds(30, 180, 125, 20);
        add(name);

        nameField= new JTextField();
        nameField.setBounds(170, 180, 125, 20);
        add(nameField);

        JLabel password= new JLabel("Password");
        password.setBounds(30, 220, 125, 20);
        add(password);

        passwordField= new JPasswordField();
        passwordField.setBounds(170, 220, 125, 20);
        add(passwordField);

        loginaschoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String userType = loginaschoice.getSelectedItem();
                if (userType.equals("Admin")) {
                    meternumberField.setVisible(false);
                    meternumber.setVisible(false);
                    employeeField.setVisible(true);
                    employer.setVisible(true);
                } else if(userType.equals("Customer")) {
                    meternumberField.setVisible(true);
                    meternumber.setVisible(true);
                    employeeField.setVisible(false);
                    employer.setVisible(false);
                }
            }
        });

        createButton= new JButton("Create");
        createButton.setBackground(new Color(66, 127, 219));
        createButton.setForeground(Color.black);
        createButton.setBounds(30, 270, 100, 20);
        createButton.addActionListener(this);
        add(createButton);

        backButton= new JButton("Back");
        backButton.setBackground(new Color(66, 127, 219));
        backButton.setForeground(Color.black);
        backButton.setBounds(170, 270, 100, 20);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon imageicon= new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image imageOne= imageicon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon imageicon2= new ImageIcon(imageOne);
        JLabel imageLabel = new JLabel(imageicon2);
        imageLabel.setBounds(320, 50, 250, 250);
        add(imageLabel);



        setSize(600,380);
        setLocation(500,200);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createButton) {
            String userType = loginaschoice.getSelectedItem();
            String meternumber = meternumberField.getText();
            String username = usernameField.getText();
            String name = nameField.getText();
            String password = passwordField.getText();
            try{
                database db = new database();
                String query = "INSERT INTO signup (meternumber, username, name, password, userType) VALUES ('" + meternumber + "', '" + username + "', '" + name + "', '" + password + "', '" + userType + "')";
                db.statement.executeUpdate(query);
            }catch (Exception ex) {
                ex.printStackTrace();
            }

            if (userType.equals("Admin")) {
                if (username.isEmpty() || name.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required for Admin");
                } else {
                    // Code to create admin account
                    JOptionPane.showMessageDialog(null, "Admin account created successfully");
                    new login();
                }
            } else if (userType.equals("Customer")) {
                if (meternumber.isEmpty() || username.isEmpty() || name.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required for Customer");
                } else {
                    // Code to create customer account
                    JOptionPane.showMessageDialog(null, "Customer account created successfully");
                    new login();
                }
            }
        } else if (e.getSource() == backButton) {
            setVisible(false);
            new login(); // Assuming login is another class that handles the login screen
        }

    }
    public static void main(String[] args) {
        new signup();
    }
}
