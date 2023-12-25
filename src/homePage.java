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
        card = new userCard("Yusuf", "RP 100000", "res/wireFrameProfileIcon.png");
        card2 = new foodCard("Holiaw",30_000,"res/holiawIcon.png", "Non-Halal", "Noodle", "<HTML> A noodle place with a simple decor that is popular for its Grilled Pork Noodles, mixed rice, and others. </HTML>");
        card3 = new foodCard("Ragusa Es Italia",10_000,"res/ragusaIcon.png", "Halal", "Ice Cream", "<HTML>Ice cream parlor serving a variety of creative desserts in a cozy space with a retro vibe. You can buy Ragusa’s surplus items inside wrapped inside a bag. </HTML>");

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