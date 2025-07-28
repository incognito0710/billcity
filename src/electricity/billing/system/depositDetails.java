package electricity.billing.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class depositDetails extends JFrame implements ActionListener {
    Choice meterChoice, monthChoice;
    JTable table;
    JButton searchButton, printButton, closeButton;
    depositDetails() {
        super("Deposit Details");
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
            ResultSet resultSet = db.statement.executeQuery("select * from bill");
            while (resultSet.next()) {
                meterChoice.add(resultSet.getString("meter_number"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }


        JLabel searchmonth = new JLabel("Search by Month:");
        searchmonth.setBounds(400, 20, 200, 20);
        add(searchmonth);
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
        monthChoice.setBounds(600, 20, 150, 20);
        add(monthChoice);

        table = new JTable();
        try {
            database db = new database();
            ResultSet resultSet = db.statement.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception E) {
            E.printStackTrace();

        }
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 800, 350);
        add(scrollPane);
        searchButton = new JButton("Search");
        searchButton.setBounds(100, 420, 100, 30);
        searchButton.setBackground(Color.darkGray);
        searchButton.setForeground(Color.white);
        searchButton.addActionListener(this);
        add(searchButton);

        printButton = new JButton("Print");
        printButton.setBounds(300, 420, 100, 30);
        printButton.setBackground(Color.darkGray);
        printButton.setForeground(Color.white);
        printButton.addActionListener(this);
        add(printButton);

        closeButton = new JButton("Close");
        closeButton.setBounds(500, 420, 100, 30);
        closeButton.setBackground(Color.darkGray);
        closeButton.setForeground(Color.white);
        closeButton.addActionListener(this);
        add(closeButton);


        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton) {
            String meterNumber = meterChoice.getSelectedItem();
            String month = monthChoice.getSelectedItem();
            try {
                database db = new database();
                ResultSet resultSet = db.statement.executeQuery("select * from bill where meter_number='" + meterNumber + "' and month='" + month + "'");
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == printButton) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new depositDetails();

    }


}
