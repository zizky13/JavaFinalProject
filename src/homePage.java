import javax.swing.*;
import java.awt.*;

public class homePage {

    JFrame homeWindow;
    JButton basketButton, userButton, discoverButton;
    JPanel playerCard, foodCard1, foodCard2, foodCard3;
    createCard card, card2;
    public homePage(){
        homeWindow = new JFrame();
        homeWindow.setSize(400, 300);
        homeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeWindow.getContentPane().setBackground(Color.white);
        homeWindow.setLayout(new GridLayout(3, 1));
        card = new createCard("Yusuf", "10_000", "res/logo_UPJ.png");
        card2 = new createCard("Muhlis","5_000","res/logo_UPJ.png");
        homeWindow.add(card.cardPanel);
        homeWindow.add(card2.cardPanel);
        homeWindow.setVisible(true);
//        homeWindow.add(createCard.cardPanel);
//        homeWindow.add(createCard.cardPanel);

    }

}
