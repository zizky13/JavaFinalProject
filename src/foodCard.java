import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class foodCard extends cardProps {
    JPanel panelTengah, panelBawah;
    JLabel halalTag, typeTag, rating;
    backButton back;

    public foodCard(String foodName, String foodCost, String photoPath) {
        //================== PANEL INIT =====================
        cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());
        cardPanel.setBackground(new Color(86,158,158));

        //================== NAME PANEL INIT =====================
        tengahPanel = new JPanel();
        tengahPanel.setLayout(null);
        tengahPanel.setBounds(5,5,200,30);
        tengahPanel.setBackground(Color.white);

        //================== NAME LABEL INIT =====================
        nameLabel = new JLabel(foodName, SwingConstants.CENTER);
        nameLabel.setBounds(0,0,95,30);
        nameLabel.setBackground(Color.white);
        nameLabel.setOpaque(true);


        //================== BALANCE LABEL INIT =====================
        balanceLabel = new JLabel("price: " + foodCost,SwingConstants.CENTER);
        balanceLabel.setBounds(100,0,95,30);
        balanceLabel.setBackground(Color.white);
        balanceLabel.setOpaque(true);

        //================== PHOTO LABEL INIT =====================
        photo = new ImageIcon(photoPath);
        Image userPhoto = photo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(userPhoto);
        photoLabel = new JLabel(resizedIcon, SwingConstants.LEFT);
        photoLabel.setBackground(new Color(86,158,158));
        photoLabel.setOpaque(true);

        //================== FRAME INIT =====================
        descPanel = new JPanel();
        descPanel.setBackground(new Color(86,158,158));
        descPanel.setBounds(5, 40, 200, 115);
        descPanel.setLayout(null);
        descText = new JLabel();
        descText.setText("<HTML>Lorem Ipsum Dummy Text Lorem Ipsum Dummy Text Lorem Ipsum Dummy Text Lorem Ipsum Dummy Text</HTML>");
        descText.setVerticalAlignment(JLabel.TOP);
        descText.setBounds(5, 0, 180, 100);
        descPanel.add(descText);
        descPanel.setBorder(BorderFactory.createLineBorder(Color.white,3));

        //================== MIDDLE PANEL INIT =====================
        panelTengah = new JPanel();
        panelTengah.setLayout(null);
        panelTengah.setBackground(new Color(86,158,158));
        panelTengah.setOpaque(true);
        panelTengah.add(tengahPanel);
        panelTengah.add(descPanel);



        //================== BOTTOM PANEL INIT =====================
        panelBawah = new JPanel();
        panelBawah.setBackground(Color.white);
        GridLayout layout =  new GridLayout(0,3);
        layout.setHgap(10);
        panelBawah.setLayout(layout);

        //================== HALAL TAG INIT =====================
        halalTag = new JLabel("Halal");
        halalTag.setHorizontalAlignment(JLabel.CENTER);
        halalTag.setOpaque(true);
        halalTag.setBackground(Color.green);
        halalTag.setForeground(Color.black);

        //================== FOOD TYPE TAG INIT =====================
        typeTag = new JLabel("Soup");
        typeTag.setHorizontalAlignment(JLabel.CENTER);
        typeTag.setOpaque(true);
        typeTag.setBackground(Color.cyan);
        typeTag.setForeground(Color.black);

        //================== RATING INIT =====================
        rating = new JLabel("4.7");
        rating.setHorizontalAlignment(JLabel.CENTER);
        rating.setOpaque(true);
        rating.setBackground(Color.yellow);
        rating.setForeground(Color.black);

        //================== ADDING TO BOTTOM PANEL =====================
        panelBawah.add(halalTag);
        panelBawah.add(typeTag);
        panelBawah.add(rating);
        panelBawah.setBounds(5,160,200,15);
        panelBawah.setBackground(new Color(86,158,158));
        panelBawah.setOpaque(true);
        panelTengah.add(panelBawah);

        //================== ADDING TO NAME PANEL =====================
        tengahPanel.add(nameLabel);
        tengahPanel.add(balanceLabel);
        tengahPanel.setBackground(new Color(86,158,158));

        //================== ADDING TO CARD PANEL INIT =====================
        cardPanel.add(panelTengah, BorderLayout.CENTER);
        cardPanel.add(photoLabel, BorderLayout.WEST);
//        cardPanel.add(panelBawah, BorderLayout.SOUTH);

        //================== CARD PANEL MOUSE LISTENER =====================
        back = new backButton();
        back.setVisible(false);
        cardPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // When the card is clicked, open details page for this food item
                openDetailsPage(foodName); // Pass food name or ID to details page
            }
        });
    }

    //========== CONDITIONAL TO DECIDE WHAT PAGE TO OPEN AFTER CLICK ==========
    public void openDetailsPage(String foodname){
        switch (foodname){
            case "Lo Ciento":
                loCiento yeet = new loCiento();
                backButton.viewStack.push(homePage.homeFrame);
                break;
            case "Ragusa":
                foodDetails jeez = new foodDetails("res/gambarEskrim.png");
                homePage.homeFrame.dispose();
                backButton.viewStack.push(homePage.homeFrame);
                break;
        }
    }
}
