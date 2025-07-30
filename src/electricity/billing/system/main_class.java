package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    String acctype;
    String meterpass;
    main_class( String acctype,String meterpass){
        this.acctype = acctype;
        this.meterpass = meterpass;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
        Image image = imageIcon.getImage().getScaledInstance(1530, 830, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        add(imageLabel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif",Font.BOLD,20));


        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon newCustomerIcon = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image newCustomerImage = newCustomerIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon newCustomerIcon2 = new ImageIcon(newCustomerImage);
        newCustomer.setIcon(  newCustomerIcon2);
        newCustomer.addActionListener(this);
        menu.add(newCustomer);


        JMenuItem Customerdetails = new JMenuItem("Customer Details");
        Customerdetails.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon CustomerdetailsIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customerdetails.png"));
        Image CustomerdetailsImage = CustomerdetailsIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon CustomerdetailsIcon2 = new ImageIcon(CustomerdetailsImage);
        Customerdetails.setIcon(CustomerdetailsIcon2);
        Customerdetails.addActionListener(this);
        menu.add(Customerdetails);


        JMenuItem depositdetails = new JMenuItem("deposit details");
        depositdetails.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon depositdetailsIcon = new ImageIcon(ClassLoader.getSystemResource("icon/depositedetails.png"));
        Image depositdetailsImage = depositdetailsIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon depositdetailsIcon2 = new ImageIcon(depositdetailsImage);
        depositdetails.setIcon(depositdetailsIcon2);
        depositdetails.addActionListener(this);
        menu.add(depositdetails);

        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon calculateBillIcon = new ImageIcon(ClassLoader.getSystemResource("icon/calculatebill.png"));
        Image calculateBillImage = calculateBillIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon calculateBillIcon2 = new ImageIcon(calculateBillImage);
        calculateBill.setIcon(calculateBillIcon2);
        calculateBill.addActionListener(this);
        menu.add(calculateBill);

        JMenu info = new JMenu("Information");
        info.setFont(new Font("serif", Font.BOLD, 20));


        JMenuItem upinfo = new JMenuItem("update information");
        upinfo.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon upinfoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updateinfo.png"));
        Image upinfoImage = upinfoIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon upinfoIcon2 = new ImageIcon(upinfoImage);
        upinfo.setIcon(upinfoIcon2);
        upinfo.addActionListener(this);
        info.add(upinfo);

        JMenuItem viewinfo = new JMenuItem("view information");
        viewinfo.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon viewinfoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/viewinfo.png"));
        Image viewinfoImage = viewinfoIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon viewinfoIcon2 = new ImageIcon(viewinfoImage);
        viewinfo.setIcon(viewinfoIcon2);
        viewinfo.addActionListener(this);
        info.add(viewinfo);

        JMenu user = new JMenu("User");
        user.setFont(new Font("serif", Font.BOLD, 20));

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon paybillIcon = new ImageIcon(ClassLoader.getSystemResource("icon/paybill.png"));
        Image paybillImage = paybillIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon paybillIcon2 = new ImageIcon(paybillImage);
        paybill.addActionListener(this);
        paybill.setIcon(paybillIcon2);
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon billdetailsIcon = new ImageIcon(ClassLoader.getSystemResource("icon/billdetails.png"));
        Image billdetailsImage = billdetailsIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon billdetailsIcon2 = new ImageIcon(billdetailsImage);
        billdetails.setIcon(billdetailsIcon2);
        billdetails.addActionListener(this);
        user.add(billdetails);

        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("serif", Font.BOLD, 20));


        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon generateBillIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image generateBillImage = generateBillIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon generateBillIcon2 = new ImageIcon(generateBillImage);
        generateBill.setIcon(generateBillIcon2);
        generateBill.addActionListener(this);
        bill.add(generateBill);

        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("serif", Font.BOLD, 20));


        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image notepadImage = notepadIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon notepadIcon2 = new ImageIcon(notepadImage);
        notepad.setIcon(notepadIcon2);
        notepad.addActionListener(this);

        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon calculatorIcon = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image calculatorImage = calculatorIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon calculatorIcon2 = new ImageIcon(calculatorImage);
        calculator.setIcon(calculatorIcon2);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("serif", Font.BOLD, 20));


        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(new Font("monospaced", Font.PLAIN, 16));
        ImageIcon exitIcon = new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
        Image exitImage = exitIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon exitIcon2 = new ImageIcon(exitImage);
        exitItem.setIcon(exitIcon2);
        exitItem.addActionListener(this);
        exit.add(exitItem);

        if(acctype.equals("Admin")){
            menuBar.add(menu);

        } else {
            menuBar.add(user);
            menuBar.add(info);
            menuBar.add(bill);


        }
        menuBar.add(utility);
        menuBar.add(exit);




        setLayout(new FlowLayout());
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if (msg.equals("New Customer")) {
            new newcustomer();
        } else if (msg.equals("Customer Details")) {
            new customerDetails();
        } else if (msg.equals("deposit details")) {
            new depositDetails();
        } else if (msg.equals("Calculate Bill")) {
            new calculateBill();
        }else if (msg.equals("view information")) {
            new viewInformation(meterpass);
        }  else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            System.exit(0);


        }
    }
    public static void main(String[] args) {
        new main_class(" ","");
    }


}
