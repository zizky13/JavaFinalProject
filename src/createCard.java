import javax.swing.*;
import java.awt.*;

public class createCard {
    JPanel cardPanel;
    JLabel nameLabel, balanceLabel, photoLabel;
    ImageIcon photo;
    ImageIcon fotoResize;

    public createCard(String userName, String balance, String photoPath) {
        cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());
        nameLabel = new JLabel(userName, SwingConstants.CENTER);
        nameLabel.setFont(new Font(null, Font.PLAIN, 30));
        balanceLabel = new JLabel("Balance" + balance);
        photo = new ImageIcon(photoPath);

        // Get the image from the ImageIcon
        Image originalImage = photo.getImage();

        // Resize the image to the specified width and height
        Image resizedImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the resized image
        fotoResize = new ImageIcon(resizedImage);

        // Create the JLabel with the ImageIcon
        photoLabel = new JLabel(fotoResize);

        cardPanel.add(nameLabel, BorderLayout.NORTH);
        cardPanel.add(photoLabel, BorderLayout.CENTER);
        cardPanel.add(balanceLabel, BorderLayout.SOUTH);
    }
}
