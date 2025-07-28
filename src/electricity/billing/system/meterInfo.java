package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener {
       Choice meterlocchoice,metertypechoice,phaseCodechoice,billTypechoice;
       JButton submitButton;
       String meterNum;

     meterInfo(String meterNum){
         this.meterNum = meterNum;
         JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(new Color(67, 226, 147, 119));
            add(panel);

            JLabel heading = new JLabel("Meter Information");
            heading.setBounds(150, 20, 200, 30);
            heading.setFont(new Font("Tahome", Font.BOLD, 20));
            panel.add(heading);

            JLabel meternumber = new JLabel("Meter Number:");
            meternumber.setBounds(50, 80, 150, 20);
            panel.add(meternumber);

            JLabel meternumberField = new JLabel(meterNum);
            meternumberField.setBounds(200, 80, 150, 20);
            panel.add(meternumberField);

            JLabel meterloc= new JLabel("Meter Location:");
            meterloc.setBounds(50, 120, 150, 20);
            panel.add(meterloc);

            meterlocchoice = new Choice();
            meterlocchoice.add("outside");
            meterlocchoice.add("inside");
            meterlocchoice.setBounds(200, 120, 150, 20);
            panel.add(meterlocchoice);

            JLabel metertype = new JLabel("Meter Type:");
            metertype.setBounds(50, 160, 150, 20);
            panel.add(metertype);

            metertypechoice = new Choice();
            metertypechoice.add("Electric Meter");
            metertypechoice.add("Solar Meter");
            metertypechoice.add("Smart Meter");
            metertypechoice.setBounds(200, 160, 150, 20);
            panel.add(metertypechoice);

            JLabel phaseCode = new JLabel("Phase code:");
            phaseCode.setBounds(50, 200, 150, 20);
            panel.add(phaseCode);

            phaseCodechoice = new Choice();
            phaseCodechoice.add("011");
            phaseCodechoice.add("022");
            phaseCodechoice.add("033");
            phaseCodechoice.add("044");
            phaseCodechoice.add("055");
            phaseCodechoice.add("066");
            phaseCodechoice.add("077");
            phaseCodechoice.add("088");
            phaseCodechoice.add("099");
            phaseCodechoice.setBounds(200, 200, 150, 20);
            panel.add(phaseCodechoice);

            JLabel buillType = new JLabel("Buill Type:");
            buillType.setBounds(50, 240, 150, 20);
            panel.add(buillType);

            billTypechoice = new Choice();
            billTypechoice.add("Normal");
            billTypechoice.add("Industrial");
            billTypechoice.add("Commercial");
            billTypechoice.add("Agricultural");
            billTypechoice.setBounds(200, 240, 150, 20);
            panel.add(billTypechoice);

            JLabel day= new JLabel("30 Day billing time.......");
            day.setBounds(50, 280, 150, 20);
            panel.add(day);

            JLabel note = new JLabel("Note");
            note.setBounds(50, 320, 150, 20);
            panel.add(note);

            JLabel noteField = new JLabel("By default, the billing time is 30 days.");
            noteField.setBounds(50, 340, 300, 20);
            panel.add(noteField);

            submitButton = new JButton("Submit");
            submitButton.setBounds(100, 380, 100, 30);
            submitButton.setBackground(Color.darkGray);
            submitButton.setForeground(Color.white);
            submitButton.addActionListener(this);
            panel.add(submitButton);

            setLayout(new BorderLayout());
            add(panel, "Center");

            ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/meterinfo.png"));
            Image imageOne = imageicon.getImage().getScaledInstance(300, 500, Image.SCALE_DEFAULT);
            ImageIcon imageicon2 = new ImageIcon(imageOne);
            JLabel imageLabel = new JLabel(imageicon2);
            add(imageLabel, "East");

         setSize(800, 500);
         setLocation(400, 200);
         setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submitButton){
            String meternum = meterNum;
            String meterLocation = meterlocchoice.getSelectedItem();
            String meterType = metertypechoice.getSelectedItem();
            String phaseCode = phaseCodechoice.getSelectedItem();
            String billType = billTypechoice.getSelectedItem();
            String dayBilling = "30"; // Default billing time

            String query_meterinfo = "INSERT INTO meter_info values ('" + meternum + "', '" + meterLocation + "', '" + meterType + "', '" + phaseCode + "', '" + billType + "', '" + dayBilling + "')";
            try {
                database db = new database();
                db.statement.executeUpdate(query_meterinfo);

                JOptionPane.showMessageDialog(this, "Meter Information Submitted:\n" +
                        "Location: " + meterLocation + "\n" +
                        "Type: " + meterType + "\n" +
                        "Phase Code: " + phaseCode + "\n" +
                        "Bill Type: " + billType);
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new meterInfo(" ");


    }
}
