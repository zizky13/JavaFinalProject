import javax.swing.*;
import java.awt.*;

public class foodCard {
    JPanel cardPanel, namePanel;
    JLabel nameLabel, balanceLabel, photoLabel;
    ImageIcon photo, resizedIcon;
    public foodCard(String userName, String balance, String photoPath){
        cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());

        namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 200, 20));
        nameLabel = new JLabel(userName);
        namePanel.add(nameLabel);

        balanceLabel = new JLabel("Balance: " + balance, SwingConstants.CENTER);

        photo = new ImageIcon(photoPath);
        int width = 50;
        int height = 50;
        Image userPhoto = photo.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(userPhoto);
        photoLabel = new JLabel(resizedIcon, SwingConstants.LEFT);


        cardPanel.add(namePanel,BorderLayout.CENTER);
        cardPanel.add(photoLabel, BorderLayout.WEST);
        cardPanel.add(balanceLabel, BorderLayout.SOUTH);
    }
}