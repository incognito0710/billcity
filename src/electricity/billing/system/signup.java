package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

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

        nameField= new JTextField(" ");
        nameField.setBounds(170, 180, 125, 20);
        add(nameField);
        meternumberField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    database db = new database();
                    ResultSet rs = db.statement.executeQuery("select * from signup where meter_number = '" + meternumberField.getText() + "'");
                    if(rs.next()) {
                        nameField.setText(rs.getString("name"));

                    }
            }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

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
                if (userType.equals("Customer")) {
                    employer.setVisible(false);
                    nameField.setEditable(false);
                    employeeField.setVisible(false);
                    meternumber.setVisible(true);
                    meternumberField.setVisible(true);
                }
                else if( userType.equals("admin")) {
                    employer.setVisible(true);
                    employeeField.setVisible(true);
                    meternumber.setVisible(false);
                    meternumberField.setVisible(false);
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
                String query =null;
                if(userType.equals("Admin")){
                query = "INSERT INTO signup value ('" + meternumber + "', '" + username + "', '" + name + "', '" + password + "', '" + userType + "')";
                }
                else {
                query = "update  signup  set username = '" + username + "', password = '" + password + "', usertype = '" + userType + "' where meter_number = '" + meternumber + "'";
                }
                db.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new login(); // Assuming login is another class that handles the login screen
            }catch (Exception ex) {
                ex.printStackTrace();
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
