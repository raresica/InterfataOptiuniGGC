import javax.swing.*;
import java.awt.*;


public class Romania extends JPanel{
    private JFrame f = new JFrame("Destinatie Vacanta");
    public Romania(JTextField field, String str) {
        ImageIcon city = new ImageIcon(("S:/Sem 4/GGC/Lab11/src/oras_Romania.jpg"));
        Image img = city.getImage() ;
        Image cityScaled = img.getScaledInstance( 800, 400,  java.awt.Image.SCALE_SMOOTH ) ;
        city = new ImageIcon(cityScaled);
        field.setOpaque( false );
        JLabel label = new JLabel( city);
        label.setLayout( new BorderLayout() );
        label.add( field );
        field.setFont(new Font("New Times Roman", Font.BOLD, 35));
        field.setText(str + " este foarta frumoasa, merita vizitata!");
        field.setForeground(Color.BLUE);
        f.add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
