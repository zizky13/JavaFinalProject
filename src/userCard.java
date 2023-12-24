import javax.swing.*;
import java.awt.*;

public class userCard extends cardProps{

    public userCard(String userName, String balance, String photoPath){
        //card panel
        cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());

        //balance and name panel
        tengahPanel = new JPanel();
        tengahPanel.setLayout(null);
        tengahPanel.setBackground(new Color(86,158,158));

        //Panel untuk NameLabel dan BalanceLabel
        JPanel atasTengahPanel = new JPanel();
        atasTengahPanel.setLayout(null);
        atasTengahPanel.setBounds(10,5,185,65);
        atasTengahPanel.setBackground(new Color(86,158,158));
        atasTengahPanel.setOpaque(true);
        atasTengahPanel.setBorder(BorderFactory.createLineBorder(Color.white, 3));

        //NameLabel
        nameLabel = new JLabel("Hi " + userName + " !");
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setBounds(0,5,185,25);


        //BalanceLabel
        balanceLabel = new JLabel("Balance: " + balance);
        balanceLabel.setHorizontalAlignment(JLabel.CENTER);
        balanceLabel.setBounds(15,35,155,20);
        balanceLabel.setBackground(new Color(112,207,112));
        balanceLabel.setOpaque(true);

        //StatusLabel
        statusLabel = new JLabel("<HTML>Lorem Ipsum Dummy Text Lorem Ipsum Dummy Text Lorem Ipsum Dummy Text Lorem Ipsum Dummy Text</HTML>");
        statusLabel.setVerticalAlignment(JLabel.TOP);
        statusLabel.setBounds(10,80,185,90);
        statusLabel.setBackground(new Color(86,158,158));
        statusLabel.setOpaque(true);
        statusLabel.setBorder(BorderFactory.createLineBorder(Color.white, 3));


        //photo panel
        photo = new ImageIcon(photoPath);
        Image userPhoto = photo.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(userPhoto);
        photoLabel = new JLabel(resizedIcon, SwingConstants.LEFT);
        photoLabel.setBackground(new Color(86,158,158));
        photoLabel.setOpaque(true);

//        descPanel = new JPanel();
//        descText = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
//        descText.setBackground(Color.black);
//        descText.setForeground(Color.white);
//        descText.setLineWrap(true);
//        descPanel.add(descText);


//        tengahPanel.add(nameLabel);
//        tengahPanel.add(balanceLabel);
        atasTengahPanel.add(nameLabel);
        atasTengahPanel.add(balanceLabel);
        tengahPanel.add(atasTengahPanel);
        tengahPanel.add(statusLabel);
        cardPanel.add(tengahPanel,BorderLayout.CENTER);
        cardPanel.add(photoLabel, BorderLayout.WEST);
    }
}