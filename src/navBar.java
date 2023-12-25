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
        discover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage home = new homePage();
                foodDetails.restoFrame.setVisible(false);
            }
        });


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
    public navBar(JFrame frame){
        JPanel navPanel = new JPanel();
        navPanel.setLayout(null);
        navPanel.setBounds(0,610,400,73); //sisa 41
        navPanel.setBackground(Color.red);
        frame.add(navPanel);

        JButton user = new JButton(resized("res/UserButtonBaru2.png", 133, 73));
        user.setBounds(0,0,133,73);
        navPanel.add(user);

        JButton discover = new JButton(resized("res/DiscoverButtton.png", 133, 73));
        discover.setBounds(133,0,133,73);
        navPanel.add(discover);
        discover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (foodDetails.restoFrame != null){
                    if(homePage.homeFrame != null){
                        foodDetails.restoFrame.dispose();
                        homePage home = new homePage();
                    }
                }
            }
        });

        //discover button listener
        discover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (keranjangPage.keranjangFrame != null || homePage.homeWindow == null){
//                    keranjangPage.keranjangFrame.dispose();
//                    homePage home = new homePage();
//                }
            }
        });

        JButton keranjang = new JButton(resized("res/CartButtton.png", 133, 73));
        keranjang.setBounds(266,0,133,73);
        navPanel.add(keranjang);
        keranjang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keranjangPage keranjang = new keranjangPage();
            }
        });
    }

    private ImageIcon resized(String photoPath, int Width, int Height){
        ImageIcon photo = new ImageIcon(photoPath);
        Image userPhoto = photo.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
        return new ImageIcon(userPhoto);
    }
}
