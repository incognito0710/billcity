package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class calculateBill extends JFrame implements ActionListener {
    Choice meternumberChoice,monthChoice;
    JLabel nameField,addressField;
    JTextField unitConsumedField;
    JButton submitButton, cancelButton;
    calculateBill(){
        super("Electricity Bill Calculator");


          JPanel panel = new JPanel();
          panel.setLayout(null);
          panel.setBackground(new Color(214,195,247));
          add(panel);

            JLabel heading = new JLabel("Calculate Electricity Bill");
            heading.setBounds(100, 10, 300, 30);
            heading.setFont(new Font("Tahome", Font.BOLD, 25));
            panel.add(heading);

            JLabel meternumber = new JLabel("meternumber:");
            meternumber.setBounds(60, 80, 150, 20);
            panel.add(meternumber);

            meternumberChoice = new Choice();
            try{
                database db = new database();
                ResultSet resultSet= db.statement.executeQuery("select * from newcustomer");
                while (resultSet.next()){
                    meternumberChoice.add(resultSet.getString("meter_number"));
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            meternumberChoice.setBounds(250, 80, 150, 20);
            panel.add(meternumberChoice);


            JLabel name = new JLabel("Name:");
            name.setBounds(60, 120, 150, 20);
            panel.add(name);

            nameField = new JLabel();
            nameField.setBounds(250, 120, 150, 20);
            panel.add(nameField);

            JLabel address = new JLabel("Address:");
            address.setBounds(60, 160, 150, 20);
            panel.add(address);

            addressField = new JLabel();
            addressField.setBounds(250, 160, 150, 20);
            panel.add(addressField);

            try{
                database db = new database();
                ResultSet resultSet= db.statement.executeQuery("select * from newcustomer where meter_number='"+meternumberChoice.getSelectedItem()+"'");
                while (resultSet.next()){
                    nameField.setText(resultSet.getString("name"));
                    addressField.setText(resultSet.getString("address"));

                }

            }catch (Exception e){
                e.printStackTrace();
            }
            meternumberChoice.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    try{
                        database db = new database();
                        ResultSet resultSet= db.statement.executeQuery("select * from newcustomer where meter_number='"+meternumberChoice.getSelectedItem()+"'");
                        while (resultSet.next()){
                            nameField.setText(resultSet.getString("name"));
                            addressField.setText(resultSet.getString("address"));

                        }

                    }catch (Exception E){
                        E.printStackTrace();
                    }

                }
            });

            JLabel unitconsumed = new JLabel("Unit Consumed:");
            unitconsumed.setBounds(60, 200, 150, 20);
            panel.add(unitconsumed);

            unitConsumedField = new JTextField();
            unitConsumedField.setBounds(250, 200, 150, 20);
            panel.add(unitConsumedField);

            JLabel month= new JLabel("Month:");
            month.setBounds(60, 240, 150, 20);
            panel.add(month);

            monthChoice = new Choice();
            monthChoice.add("January");
            monthChoice.add("February");
            monthChoice.add("March");
            monthChoice.add("April");
            monthChoice.add("May");
            monthChoice.add("June");
            monthChoice.add("July");
            monthChoice.add("August");
            monthChoice.add("September");
            monthChoice.add("October");
            monthChoice.add("November");
            monthChoice.add("December");
            monthChoice.setBounds(250, 240, 150, 20);
            panel.add(monthChoice);

            submitButton = new JButton("Submit");
            submitButton.setBounds(100, 300, 100, 30);
            submitButton.setBackground(Color.darkGray);
            submitButton.setForeground(Color.white);
            submitButton.addActionListener(this);
            panel.add(submitButton);

            cancelButton = new JButton("Cancel");
            cancelButton.setBounds(250, 300, 100, 30);
            cancelButton.setBackground(Color.darkGray);
            cancelButton.setForeground(Color.white);
            cancelButton.addActionListener(this);
            panel.add(cancelButton);


            setLayout(new BorderLayout());
            add(panel,"Center");
            ImageIcon imageicon= new ImageIcon(ClassLoader.getSystemResource("icon/billcalculation.png"));
            Image imageOne= imageicon.getImage().getScaledInstance(300, 500, Image.SCALE_DEFAULT);
            ImageIcon imageicon2= new ImageIcon(imageOne);
            JLabel imageLabel = new JLabel(imageicon2);
            imageLabel.setBounds(450, 50, 250, 250);
            add(imageLabel,"East");

            setSize(750, 500);
            setLocation(500, 200);
            setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton){
            String meternumber= meternumberChoice.getSelectedItem();
            String unit= unitConsumedField.getText();
            String month= monthChoice.getSelectedItem();

            int totalBill=0;
            int units = Integer.parseInt(unit);
            String query_tax= "select * from tax";
            try{
                database db = new database();
                ResultSet resultSet= db.statement.executeQuery(query_tax);
                while (resultSet.next()){
                    totalBill+= units * Integer.parseInt(resultSet.getString("cost_per_unit"));
                    totalBill+= Integer.parseInt(resultSet.getString("meter_rent"));
                    totalBill+= Integer.parseInt(resultSet.getString("service_charge"));
                    totalBill+= Integer.parseInt(resultSet.getString("service_tax"));
                    totalBill+= Integer.parseInt(resultSet.getString("swacch_bharat"));
                    totalBill+= Integer.parseInt(resultSet.getString("fixed_tax"));

                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            String query_bill= "insert into bill values('"+meternumber+"','"+month+"','"+unit+"','"+totalBill+"','not paid')";
            try{
                database db = new database();
                db.statement.executeUpdate(query_bill);
                JOptionPane.showMessageDialog(null, "Bill Calculated Successfully\nTotal Bill: "+totalBill);
                setVisible(false);
            }catch (Exception ex){
                ex.printStackTrace();
            }



    }else {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new calculateBill();

    }
}


