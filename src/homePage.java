import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class homePage {

    JFrame homeWindow;
    JButton basketButton, userButton, discoverButton;
    JPanel buttonPanel;
    foodCard card, card2, card3;

    public homePage(){
        homeWindow = new JFrame();
        homeWindow.setSize(400, 720);
        homeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeWindow.getContentPane().setBackground(Color.white);
        homeWindow.setLayout(new GridLayout(4, 0));
        card = new foodCard("Yusuf", "10_000", "res/logo_UPJ.png");
        card2 = new foodCard("Muhlis","5_000","res/logo_UPJ.png");
        card3 = new foodCard("Dimas","2_000","res/logo_UPJ.png");
        homeWindow.add(card.cardPanel);
        homeWindow.add(card2.cardPanel);
        homeWindow.add(card3.cardPanel);
        buttonPanel = new JPanel();
        Dimension buttonPanelSize = new Dimension(400, 10); // Sesuaikan dengan preferensi Anda
        buttonPanel.setPreferredSize(buttonPanelSize);
        buttonPanel.setBackground(Color.CYAN);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(basketButton = new JButton("haha"));
        buttonPanel.add(userButton = new JButton("haha"));
        buttonPanel.add(discoverButton = new JButton("haha"));
        homeWindow.add(buttonPanel);
        homeWindow.setVisible(true);

    }

}
