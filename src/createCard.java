import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class createCard {
    JPanel cardPanel;
    JLabel nameLabel, balanceLabel, photoLabel;
    ImageIcon photo;
    public createCard(String userName, String balance, String photoPath){
        cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());
        nameLabel = new JLabel(userName);
        balanceLabel = new JLabel("Balance" + balance);
        photo = new ImageIcon(photoPath);
        photoLabel = new JLabel(photo);
        cardPanel.add(nameLabel, BorderLayout.NORTH);
        cardPanel.add(photoLabel, BorderLayout.CENTER);
        cardPanel.add(balanceLabel, BorderLayout.SOUTH);
    }
}
