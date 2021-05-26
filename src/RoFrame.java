import javax.swing.*;
import java.awt.*;


public class RoFrame extends JPanel{
    private JFrame f = new JFrame("Destinatie Vacanta");
    public RoFrame(JTextField field, String str) {
        ImageIcon city = new ImageIcon(("S:/Sem 4/GGC/Lab11/src/city.jpg"));
        Image img = city.getImage() ;
        Image cityScaled = img.getScaledInstance( 1200, 350,  java.awt.Image.SCALE_SMOOTH ) ;
        city = new ImageIcon(cityScaled);
        field.setOpaque( false );
        JLabel label = new JLabel( city);
        label.setLayout( new BorderLayout() );
        label.add( field );
        field.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
        field.setText(str + " este o alegere excelenta! Sa ai parte de o vacanta de neuitat!");
        field.setForeground(Color.BLACK);
        f.add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1200,300);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
