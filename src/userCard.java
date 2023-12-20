import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class userCard extends cardProps{

    public userCard(String userName, String balance, String photoPath){
        //card panel
        cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());

        //balance and name panel
        namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
        nameLabel = new JLabel(userName);

        //balance label
        balanceLabel = new JLabel("Balance: " + balance);

        //photo panel
        photo = new ImageIcon(photoPath);
        Image userPhoto = photo.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(userPhoto);
        photoLabel = new JLabel(resizedIcon, SwingConstants.LEFT);

//        descPanel = new JPanel();
//        descText = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
//        descText.setBackground(Color.black);
//        descText.setForeground(Color.white);
//        descText.setLineWrap(true);
//        descPanel.add(descText);


        namePanel.add(nameLabel);
        namePanel.add(balanceLabel);
        cardPanel.add(namePanel,BorderLayout.CENTER);
        cardPanel.add(photoLabel, BorderLayout.WEST);
    }
}