package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class newcustomer extends JFrame implements ActionListener {
    JLabel heading, customername, meternumber, meternumberField,address,city,state,email,phonenumber;
    JTextField customernameField, addressField, cityField, stateField, emailField,phonenumberField;
    JButton nextButton,cancelButton;
    newcustomer(){
        super("New Customer");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(67, 226, 147, 119));
        add(panel);

        heading = new JLabel("New Customer");
        heading.setBounds(150, 20, 200, 30);
        heading.setFont(new Font("Tahome", Font.BOLD, 25));
        panel.add(heading);

        customername = new JLabel("Customer Name:");
        customername.setBounds(50, 80, 150, 20);
        panel.add(customername);

        customernameField = new JTextField();
        customernameField.setBounds(200, 80, 150, 20);
        panel.add(customernameField);

        meternumber = new JLabel("Meter Number:");
        meternumber.setBounds(50, 120, 150, 20);
        panel.add(meternumber);

        meternumberField = new JLabel(" ");
        meternumberField.setBounds(200, 120, 150, 20);
        panel.add(meternumberField);

        Random random = new Random();
        long number = random.nextLong()%1000000;
        meternumberField.setText(""+Math.abs(number));

        address = new JLabel("Address:");
        address.setBounds(50, 160, 150, 20);
        panel.add(address);

        addressField = new JTextField();
        addressField.setBounds(200, 160, 150, 20);
        panel.add(addressField);

        city = new JLabel("City:");
        city.setBounds(50, 200, 150, 20);
        panel.add(city);
        cityField = new JTextField();
        cityField.setBounds(200, 200, 150, 20);
        panel.add(cityField);

        state = new JLabel("State:");
        state.setBounds(50, 240, 150, 20);
        panel.add(state);
        stateField = new JTextField();
        stateField.setBounds(200, 240, 150, 20);
        panel.add(stateField);

        email = new JLabel("Email:");
        email.setBounds(50, 280, 150, 20);
        panel.add(email);
        emailField = new JTextField();
        emailField.setBounds(200, 280, 150, 20);
        panel.add(emailField);

        phonenumber = new JLabel("Phone Number:");
        phonenumber.setBounds(50, 320, 150, 20);
        panel.add(phonenumber);
        phonenumberField = new JTextField();
        phonenumberField.setBounds(200, 320, 150, 20);
        panel.add(phonenumberField);

        nextButton= new JButton("Next");
        nextButton.setBounds(100, 380, 100, 30);
        nextButton.setBackground(Color.white);
        nextButton.setForeground(Color.black);
        nextButton.addActionListener(this);
        panel.add(nextButton);

        cancelButton= new JButton("Cancel");
        cancelButton.setBounds(250, 380, 100, 30);
        cancelButton.setBackground(Color.white);
        cancelButton.setForeground(Color.black);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);




         setLayout(new BorderLayout());
         add(panel,"Center");
         ImageIcon imageicon= new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer1.png"));
         Image imageOne= imageicon.getImage().getScaledInstance(500, 700, Image.SCALE_DEFAULT);
         ImageIcon imageicon2= new ImageIcon(imageOne);
         JLabel imageLabel = new JLabel(imageicon2);
         add(imageLabel,"West");

         setSize(1000, 700);
         setLocation(300, 100);
         setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            String name = customernameField.getText();
            String meter = meternumberField.getText();
            String addr = addressField.getText();
            String cityName = cityField.getText();
            String stateName = stateField.getText();
            String emailId = emailField.getText();
            String phone = phonenumberField.getText();


            String query = "INSERT INTO newcustomer values ('" + name + "', '" + meter + "', '" + addr + "', '" + cityName + "', '" + stateName + "', '" + emailId + "', '" + phone + "')";
            String query2 = "INSERT INTO signup values ('" + meter + "', '',' " + name+"', '', '')";
            try{
                database db = new database();
                db.statement.executeUpdate(query);
                db.statement.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
                new meterInfo(meter);


            }catch (Exception ex) {
                ex.printStackTrace();
            }


        }else {
            setVisible(false);

        }
    }
        public static void main(String[] args) {
        new newcustomer();
    }
}
