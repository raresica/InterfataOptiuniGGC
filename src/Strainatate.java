import javax.swing.*;
import java.awt.*;


public class Strainatate extends JPanel{
    private JFrame f = new JFrame("Destinatie Vacanta");
    public Strainatate(JTextField field, String str) {
        ImageIcon city = new ImageIcon(("S:/Sem 4/GGC/Lab11/src/Copenhaga.jfif"));
        Image img = city.getImage() ;
        Image cityScaled = img.getScaledInstance( 900, 450,  java.awt.Image.SCALE_SMOOTH ) ;
        city = new ImageIcon(cityScaled);
        field.setOpaque( false );
        JLabel label = new JLabel( city);
        label.setLayout( new BorderLayout() );
        label.add( field );
        field.setFont(new Font("New Times Roman", Font.BOLD, 40));
        field.setText("Ai ajuns in " +str + ", sper ca mai ai bani!");
        field.setForeground(Color.WHITE);
        f.add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900,300);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
