package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateinformation extends JFrame implements ActionListener {
    JLabel nameLabel;
    JTextField nameValue,addressField, cityField, stateField, emailField, phoneField;
    String meter;
    JButton updateButton,cancelButton;
    updateinformation(String meter){
        this.meter = meter;
        setBounds(350, 150, 850, 650);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Update Customer Information");
        heading.setBounds(250, 0, 400, 30);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        nameLabel = new JLabel("Name :");
        nameLabel.setBounds(50, 70, 150, 20);
        add(nameLabel);

        nameValue = new JTextField();
        nameValue.setBounds(200, 70, 150, 20);
        add(nameValue);

        JLabel addressLabel = new JLabel("Address :");
        addressLabel.setBounds(50, 110, 150, 20);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(200, 110, 150, 20);
        add(addressField);

        JLabel cityLabel = new JLabel("City :");
        cityLabel.setBounds(50, 150, 150, 20);
        add(cityLabel);

        cityField = new JTextField();
        cityField.setBounds(200, 150, 150, 20);
        add(cityField);

        JLabel stateLabel = new JLabel("State :");
        stateLabel.setBounds(50, 190, 150, 20);
        add(stateLabel);

        stateField = new JTextField();
        stateField.setBounds(200, 190, 150, 20);
        add(stateField);

        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setBounds(50, 230, 150, 20);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 230, 150, 20);
        add(emailField);

        JLabel phoneLabel = new JLabel("Phone :");
        phoneLabel.setBounds(50, 270, 150, 20);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(200, 270, 150, 20);
        add(phoneField);
        try{
            database db = new database();
            ResultSet rs = db.statement.executeQuery("SELECT * FROM newcustomer WHERE meter_number = '" + meter + "'");
            if(rs.next()){
                nameValue.setText(rs.getString("name"));
                addressField.setText(rs.getString("address"));
                cityField.setText(rs.getString("city"));
                stateField.setText(rs.getString("state"));
                emailField.setText(rs.getString("email"));
                phoneField.setText(rs.getString("phone"));
            }

            } catch (Exception E) {
            E.printStackTrace();
        }
        updateButton = new JButton("Update");
        updateButton.setBounds(100,320 ,100 ,30 );
        updateButton.addActionListener(this);
        add(updateButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250,320 ,100 ,30 );
        cancelButton.addActionListener(this);
        add(cancelButton);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==updateButton){
            String name = nameValue.getText();
            String address = addressField.getText();
            String city = cityField.getText();
            String state = stateField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();

            try{
                database db = new database();
                String query = "UPDATE newcustomer SET name='"+name+"', address='"+address+"', city='"+city+"', state='"+state+"', email='"+email+"', phone='"+phone+"' WHERE meter_number='"+meter+"'";
                db.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Information Updated Successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if(e.getSource()==cancelButton){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new updateinformation("");
    }


}
