package electricity.billing.system;
import javax.swing.*;
import java.awt.*;

public class splash extends JFrame{
    splash(){
        ImageIcon imageicon= new ImageIcon(ClassLoader.getSystemResource("icon/splash.png"));
        Image imageOne= imageicon.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon imageicon2= new ImageIcon(imageOne);
        JLabel imageLabel = new JLabel(imageicon2);
        add(imageLabel);
        setSize(600, 400);
        setVisible(true);
        setLocation(500,200);
        try {
           Thread.sleep(3000);
           setVisible(false);
              new login();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new splash();
    }
}
