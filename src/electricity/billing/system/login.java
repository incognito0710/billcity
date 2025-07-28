package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JTextField usernameField, passwordField;
    Choice loginChoice;
    JButton loginButton, cancelButton, signupButton;
    login(){
        super("Login");
        getContentPane().setBackground(Color.lightGray);

        JLabel username= new JLabel("Username:");
        username.setBounds(300, 60, 100, 20);
        add(username);

        usernameField= new JTextField();
        usernameField.setBounds(400, 60, 150, 20);
        add(usernameField);


        JLabel password= new JLabel("Password:");
        password.setBounds(300, 100, 100, 20);
        add(password);

        passwordField= new JPasswordField();
        passwordField.setBounds(400, 100, 150, 20);
        add(passwordField);


        JLabel login= new JLabel("Login in as");
        login.setBounds(300, 140, 100, 20);
        add(login);

        loginChoice= new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400, 140, 150, 20);
        add(loginChoice);

        loginButton=new JButton("Login");
        loginButton.setBounds(330, 180, 100, 20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(460 ,180, 100, 20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton=new JButton("Sign Up");
        signupButton.setBounds(400, 215, 100, 20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profileOne= new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileImage= profileOne.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon profileTwo= new ImageIcon(profileImage);
        JLabel profileLabel= new JLabel(profileTwo);
        profileLabel.setBounds(30, 20, 220, 220);
        add(profileLabel);

        setSize(640,300);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);
    }
@Override
public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Login")) {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String userType = loginChoice.getSelectedItem();
            try {
                database db = new database();
                String query = "SELECT * FROM signup WHERE username='" + username + "' AND password='" + password + "' AND usertype='" + userType + "'";
                ResultSet resultSet = db.statement.executeQuery(query);
                if (resultSet.next()) {
                    String meterNumber = resultSet.getString("meter_number");
                    setVisible(false);
                    new main_class(userType, meterNumber); // Assuming main_class is the main application class
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid login", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch (Exception ex) {
                ex.printStackTrace();
            }


        } else if (actionCommand.equals("Cancel")) {
            System.exit(0);
        } else if (actionCommand.equals("Sign Up")) {
            new signup(); // Assuming signup is another class for registration
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
