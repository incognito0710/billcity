package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;


public class customerDetails extends JFrame implements ActionListener {
    Choice meterChoice,nameChoice;
    JTable table;
    JButton searchButton,printButton,closeButton;
    customerDetails() {
        super("Customer Details");
        getContentPane().setBackground(new java.awt.Color(192, 186, 254));
        setSize(800, 500);
        setLocation(400, 200);
        setLayout(null);

        JLabel searchMeter = new JLabel("Search by Meter Number:");
        searchMeter.setBounds(20, 20, 200, 20);
        add(searchMeter);

        meterChoice = new Choice();
        meterChoice.setBounds(220, 20, 150, 20);
        add(meterChoice);

        try {
            database db = new database();
            ResultSet resultSet = db.statement.executeQuery("select * from newcustomer");
            while (resultSet.next()) {
                meterChoice.add(resultSet.getString("meter_number"));
            }

        } catch (Exception E) {
            E.printStackTrace();
        }


        JLabel searchname = new JLabel("search by Name:");
        searchname.setBounds(400, 20, 200, 20);
        add(searchname);
        nameChoice = new Choice();
        nameChoice.setBounds(600, 20, 150, 20);
        add(nameChoice);

        try {
            database db = new database();
            ResultSet resultSet = db.statement.executeQuery("select * from newcustomer");
            while (resultSet.next()) {
                nameChoice.add(resultSet.getString("name"));
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
        table = new JTable();
        try {
            database db= new database();
            ResultSet resultSet = db.statement.executeQuery("select * from newcustomer");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception E) {
            E.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 800, 400);
        scrollPane.setBackground(new Color(255, 255, 255));
        add(scrollPane);

        searchButton = new JButton("Search");
        searchButton.setBackground(Color.white);
        searchButton.setForeground(Color.black);
        searchButton.setBounds(20,70, 80, 20);
        searchButton.addActionListener(this);
        add(searchButton);

        printButton=new JButton("Print");
        printButton.setBackground(Color.white);
        printButton.setBounds(120,70,80,20);
        printButton.addActionListener(this);
        add(printButton);

        closeButton=new JButton("Close");
        closeButton.setBackground(Color.white);
        closeButton.setBounds(600,70,80,20);
        closeButton.addActionListener(this);
        add(closeButton);

        setVisible(true);
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == searchButton) {
                String query_search = "select * from newcustomer where meter_number = '" + meterChoice.getSelectedItem() + "'and name ='" + nameChoice.getSelectedItem() + "'";
                try {
                    database db = new database();
                    ResultSet resultSet = db.statement.executeQuery(query_search);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception E) {
                    E.printStackTrace();
                }
            } else if (e.getSource() == printButton) {
                try {
                    table.print();
                } catch (PrinterException E) {
                    throw new RuntimeException();

                }
            }else{
                setVisible(false);
            }
    }


    public static void main(String[] args) {
        new customerDetails();

    }
}
