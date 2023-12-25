import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class homePage {

    static JFrame homeFrame;
    JButton basketButton, userButton, discoverButton;
    JPanel playerCard, foodCard1, foodCard2, foodCard3;
    userCard card;
    foodCard card2, card3;
    public homePage(){
        //================== FRAME INIT =====================
        homeFrame = new JFrame("Home Page");
        homeFrame.setSize(400, 720);
//        homeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.getContentPane().setBackground(Color.white);
        homeFrame.setLayout(null);
        homeFrame.setBackground(Color.white);
        homeFrame.setVisible(true);

        //================== CARD OBJECT INIT =====================
        card = new userCard("Yusuf", "10_000", "res/wireFrameProfileIcon.png");
        card2 = new foodCard("Lo Ciento","20_000","res/holiawIcon.png");
        card3 = new foodCard("Ragusa","30_000","res/ragusaIcon.png");

        //================== ADDING CARD TO FRAME =====================
        homeFrame.add(card.cardPanel);
        homeFrame.add(card2.cardPanel);
        homeFrame.add(card3.cardPanel);

        //================== SET BOUNDS FOR CARDS =====================
        card.cardPanel.setBounds(0,0,400,180);
        card2.cardPanel.setBounds(0,190,400,180);
        card3.cardPanel.setBounds(0,380,400,180);

        ////================== MAV BAR INIT =====================
        navBar nav = new navBar(homeFrame);

    }

}