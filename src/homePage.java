import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class homePage {

    JFrame homeWindow;
    JButton basketButton, userButton, discoverButton;
    JPanel playerCard, foodCard1, foodCard2, foodCard3;
    userCard card;
    foodCard card2, card3;
    public homePage(){
        //setting home page frame
        homeWindow = new JFrame();
        homeWindow.setSize(400, 720);
//        homeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeWindow.getContentPane().setBackground(Color.white);
        homeWindow.setLayout(null);
        homeWindow.setBackground(Color.white);

        //instatiate card object
        card = new userCard("Yusuf", "10_000", "res/logo_UPJ.png");
        card2 = new foodCard("Lo Ciento","20_000","res/logo_UPJ.png");
        card3 = new foodCard("Ragusa","30_000","res/logo_UPJ.png");

        //adding card to home page
        homeWindow.add(card.cardPanel);
        homeWindow.add(card2.cardPanel);
        homeWindow.add(card3.cardPanel);
        card.cardPanel.setBounds(0,0,400,180);
        card2.cardPanel.setBounds(0,230,400,180);
        card2.cardPanel.setBackground(Color.red);
        card3.cardPanel.setBounds(0,410,400,180);
        navBar nav = new navBar(homeWindow);
        homeWindow.setVisible(true);

    }

}