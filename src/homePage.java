import javax.swing.*;
import java.awt.*;

public class homePage {

    JFrame homeWindow;
    JButton basketButton, userButton, discoverButton;
    JPanel playerCard, foodCard1, foodCard2, foodCard3;
    foodCard card, card2, card3;
    public homePage(){
        homeWindow = new JFrame();
        homeWindow.setSize(400, 720);
        homeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeWindow.getContentPane().setBackground(Color.white);
        homeWindow.setLayout(new GridLayout(3, 1));
        card = new foodCard("Yusuf", "10_000", "res/logo_UPJ.png");
//        card2 = new createCard("Muhlis","5_000","res/logo_UPJ.png");
//        card3 = new createCard("Dimas","2_000","res/logo_UPJ.png");
        homeWindow.add(card.cardPanel);
        homeWindow.setVisible(true);
//        homeWindow.add(createCard.cardPanel);
//        homeWindow.add(createCard.cardPanel);

    }

    public static void main(String[] args) {
        homePage tampil = new homePage();
    }

}
