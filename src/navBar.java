import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class navBar {
    public navBar(JFrame frame, ImageIcon icon){
        JPanel navPanel = new JPanel();
        navPanel.setLayout(null);
        navPanel.setBounds(0,610,400,73); //sisa 41
        navPanel.setBackground(Color.red);
        frame.add(navPanel);

        JButton user = new JButton("User",icon);
        user.setBounds(0,0,133,73);
        navPanel.add(user);

        JButton discover = new JButton("Discover");
        discover.setBounds(133,0,133,73);
        navPanel.add(discover);

        JButton keranjang = new JButton("Keranjang");
        keranjang.setBounds(266,0,133,73);
        navPanel.add(keranjang);
    }
    public navBar(JFrame frame){
        JPanel navPanel = new JPanel();
        navPanel.setLayout(null);
        navPanel.setBounds(0,610,400,73); //sisa 41
        navPanel.setBackground(Color.red);
        frame.add(navPanel);

        JButton user = new JButton("User");
        user.setBounds(0,0,133,73);
        navPanel.add(user);

        JButton discover = new JButton("Discover");
        discover.setBounds(133,0,133,73);
        navPanel.add(discover);

        JButton keranjang = new JButton("Keranjang");
        keranjang.setBounds(266,0,133,73);
        navPanel.add(keranjang);
        keranjang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keranjangPage keranjang = new keranjangPage();
            }
        });
    }
}
