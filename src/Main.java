import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        final int[] nr = {0};
        JTextField field = new JTextField();
        field.setSize(200, 50);
        field.setText("");

        JFrame f = new JFrame();
        f.setPreferredSize(new Dimension(width, height));
        ImageIcon check = new ImageIcon(("S:/Sem 4/GGC/Lab11/src/Sure.png"));
        Image img = check.getImage() ;
        Image chScaled = img.getScaledInstance( 80, 65,  java.awt.Image.SCALE_SMOOTH ) ;
        check = new ImageIcon(chScaled);
        JButton alege = new JButton(check);
        alege.setVisible(false);
        alege.setOpaque(false);
        alege.setContentAreaFilled(false);
        alege.setBorderPainted(false);

        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JLabel statusLabel;
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        JPanel panelMare = new JPanel();
        JPanel panelAlege = new JPanel();
        JPanel ListaOptiuni = new JPanel();
        String[] orase = {"Brasov", "Sinaia", "Bucuresti", "Sibiu"};
        String[] tari = {"Roma","Paris","Berlin","Madrid","Londra", "Gdansk","Copenhaga"};

        JComboBox ListaOrase = new JComboBox(orase);
        ListaOrase.setSelectedIndex(3);
        ListaOrase.setPreferredSize(new Dimension(300, 90));
        ListaOrase.setFont(new Font("New Times Roman", Font.ITALIC, 50));
        final String[] mesajConfirmare = new String[1];

        JList ListaTari = new JList(tari);
        ListaTari.setPreferredSize(new Dimension(300, 400));
        ListaTari.setFont(new Font("New Times Roman", Font.ITALIC, 40));
        ListaTari.setForeground(Color.BLACK);
        ListaTari.setBackground(Color.WHITE);
        JPanel panel = new JPanel();

        ImageIcon ro = new ImageIcon(("S:/Sem 4/GGC/Lab11/src/Romania.png"));
        img = ro.getImage() ;
        Image roScaled = img.getScaledInstance( 200, 150,  java.awt.Image.SCALE_SMOOTH ) ;
        ro = new ImageIcon(roScaled);
        JButton tara = new JButton(ro);
        tara.setFont(new Font("New Times Roman", Font.BOLD, 30));
        tara.setText("Vacanta in Romania");
        tara.setPreferredSize(new Dimension(600, 150));
        tara.setOpaque(false);
        tara.setContentAreaFilled(false);
        tara.setBorderPainted(false);
        panel.add(tara);
        tara.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setFont(new Font("New Times Roman", Font.ITALIC, 90));
                statusLabel.setText("Buna alegere! PATRIOT!");
                ListaOrase.addActionListener(this);
                ListaOptiuni.remove(ListaTari);
                ListaOptiuni.add(ListaOrase);
                ListaOrase.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                      alege.setVisible(true);
                      nr[0]=1;

                        JComboBox comboBox = (JComboBox) event.getSource();

                        Object optiune = comboBox.getSelectedItem();

                        mesajConfirmare[0] = optiune.toString();
                    }
                });
                f.add(ListaOptiuni, BorderLayout.CENTER);
            }
        });


        panelMare.setPreferredSize(new Dimension(800, 800));
        panelMare.add(statusLabel);

        ImageIcon anti = new ImageIcon(("S:/Sem 4/GGC/Lab11/src/Europa.png"));
        img = anti.getImage() ;
        Image antiScaled = img.getScaledInstance( 200, 150,  java.awt.Image.SCALE_SMOOTH ) ;
        anti = new ImageIcon(antiScaled);
        JButton strainatate = new JButton(anti);
        strainatate.setFont(new Font("New Times Roman", Font.BOLD, 30));
        strainatate.setText("Vacanta in strainatate");
        strainatate.setPreferredSize(new Dimension(600, 150));
        strainatate.setOpaque(false);
        strainatate.setContentAreaFilled(false);
        strainatate.setBorderPainted(false);
        panel.add(strainatate);
        strainatate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nr[0] = 2;
                ListaTari.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                statusLabel.setFont(new Font("New Times Roman", Font.ITALIC, 70));
                statusLabel.setText("Ai gusturi, imi place");
                ListaOptiuni.remove(ListaOrase);
                ListaOptiuni.add(ListaTari);
                ListaTari.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        alege.setVisible(true);

                        JList lista = (JList) e.getSource();

                        Object optiune = lista.getSelectedValue();

                        mesajConfirmare[0] = optiune.toString();
                    }
                });
                f.add(ListaOptiuni, BorderLayout.CENTER);
            }
        });

        alege.setPreferredSize(new Dimension(80, 50));
            alege.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    if (nr[0] == 1) {
                        System.out.println(mesajConfirmare);
                        new Romania(field, mesajConfirmare[0]);
                    }
                    else if (nr[0] == 2)
                        new Strainatate(field, mesajConfirmare[0]);
                }
            });
        panelAlege.add(alege);
        f.add(statusLabel, BorderLayout.PAGE_START);
        f.add(panelAlege, BorderLayout.EAST);
        f.add(panel, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
