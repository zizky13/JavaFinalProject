import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class foodCard extends cardProps {
    public foodCard(String foodName, String foodCost, String photoPath) {
        cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());

        //balance and name panel
        namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
        nameLabel = new JLabel(foodName);

        //balance label
        balanceLabel = new JLabel("price: " + foodCost);

        //photo panel
        photo = new ImageIcon(photoPath);
        Image userPhoto = photo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(userPhoto);
        photoLabel = new JLabel(resizedIcon, SwingConstants.LEFT);

        descPanel = new JPanel();
        descText = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
        descText.setBackground(Color.black);
        descText.setForeground(Color.white);
        descText.setLineWrap(true);
        descPanel.add(descText);


        JPanel panelTengah = new JPanel();
        panelTengah.setLayout(new BoxLayout(panelTengah, BoxLayout.Y_AXIS));
        panelTengah.add(namePanel);
        panelTengah.add(descPanel);

        JPanel panelBawah = new JPanel();
        GridLayout layout =  new GridLayout(0,3);
        layout.setHgap(10);
        panelBawah.setLayout(layout);
        JLabel halalTag = new JLabel("Halal");
        halalTag.setOpaque(true);
        halalTag.setBackground(Color.green);
        halalTag.setForeground(Color.black);
        JLabel typeTag = new JLabel("Soup");
        typeTag.setOpaque(true);
        typeTag.setBackground(Color.cyan);
        typeTag.setForeground(Color.white);
        JLabel rating = new JLabel("4.7");
        rating.setOpaque(true);
        rating.setBackground(Color.yellow);
        rating.setForeground(Color.black);
        panelBawah.add(halalTag);
        panelBawah.add(typeTag);
        panelBawah.add(rating);

        namePanel.add(nameLabel);
        namePanel.add(balanceLabel);
        cardPanel.add(panelTengah, BorderLayout.CENTER);
        cardPanel.add(photoLabel, BorderLayout.WEST);
        cardPanel.add(panelBawah, BorderLayout.SOUTH);
        cardPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // When the card is clicked, open details page for this food item
                openDetailsPage(foodName); // Pass food name or ID to details page
            }
        });
    }

    public void openDetailsPage(String foodname){
        switch (foodname){
            case "Lo Ciento":
                loCiento yeet = new loCiento();
                break;
            case "Ragusa":
                ragusa jeez = new ragusa();
                break;
        }
    }
}
