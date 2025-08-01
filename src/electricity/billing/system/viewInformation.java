package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.WeakHashMap;

public class viewInformation extends JFrame implements ActionListener {
    String veiw;
    JButton closeButton;
    viewInformation(String veiw) {
        this.veiw = veiw;
        setBounds(350, 150, 850, 650);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("View  Customer Information");
        heading.setBounds(250, 0, 400, 30);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setBounds(50, 70, 150, 20);
        add(nameLabel);

        JLabel nameValue = new JLabel("");
        nameValue.setBounds(200, 70, 150, 20);
        add(nameValue);

        JLabel meternumberLabel = new JLabel("Meter Number :");
        meternumberLabel.setBounds(50, 110, 150, 20);
        add(meternumberLabel);

        JLabel meternumberValue = new JLabel("");
        meternumberValue.setBounds(200, 110, 150, 20);
        add(meternumberValue);

        JLabel addressLabel = new JLabel("Address :");
        addressLabel.setBounds(50, 150, 150, 20);
        add(addressLabel);
        JLabel addressValue = new JLabel("");
        addressValue.setBounds(200, 150, 150, 20);
        add(addressValue);

        JLabel cityLabel = new JLabel("City :");
        cityLabel.setBounds(50, 190, 150, 20);
        add(cityLabel);

        JLabel cityValue = new JLabel("");
        cityValue.setBounds(200, 190, 150, 20);
        add(cityValue);

        JLabel stateLabel = new JLabel("State :");
        stateLabel.setBounds(50, 230, 150, 20);
        add(stateLabel);
        JLabel stateValue = new JLabel("");
        stateValue.setBounds(200, 230, 150, 20);
        add(stateValue);

        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setBounds(50, 270, 150, 20);
        add(emailLabel);
        JLabel emailValue = new JLabel("");
        emailValue.setBounds(200, 270, 150, 20);
        add(emailValue);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(50, 310, 150, 20);
        add(phoneLabel);
        JLabel phoneValue = new JLabel("");
        phoneValue.setBounds(200, 310, 150, 20);
        add(phoneValue);

        try {
            database db = new database();
            ResultSet rs = db.statement.executeQuery("select * from newcustomer where meter_number= '" +veiw+ "'");
            if (rs.next()) {
                nameValue.setText(rs.getString("name"));
                meternumberValue.setText(rs.getString("meter_number"));
                addressValue.setText(rs.getString("address"));
                cityValue.setText(rs.getString("city"));
                stateValue.setText(rs.getString("state"));
                emailValue.setText(rs.getString("email"));
                phoneValue.setText(rs.getString("phonenumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        closeButton = new JButton("Close");
        closeButton.setBounds(300, 400, 100, 30);
        closeButton.setBackground(Color.BLACK);
        closeButton.setForeground(Color.WHITE);
        closeButton.addActionListener(this);
        add(closeButton);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeButton) {
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new viewInformation("512336");

    }


}
