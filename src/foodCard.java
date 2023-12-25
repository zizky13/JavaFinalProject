import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class foodCard extends cardProps {
    JPanel panelTengah, panelBawah;
    JLabel halalTag, typeTag, rating;
    backButton back;

    public foodCard(String foodName, int foodCost, String photoPath, String halalStatus, String foodType, String description) {
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
        balanceLabel = new JLabel("Rp. " + foodCost,SwingConstants.CENTER);
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
        descText.setText(description);
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
        halalTag = new JLabel(halalStatus);
        if (halalStatus == "Halal"){
            halalTag.setBackground(Color.green);
            halalTag.setOpaque(true);
        }else {
            halalTag.setBackground(Color.red);
            halalTag.setOpaque(true);
        }
        halalTag.setHorizontalAlignment(JLabel.CENTER);
        halalTag.setForeground(Color.black);

        //================== FOOD TYPE TAG INIT =====================
        typeTag = new JLabel(foodType);
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
            case "Holiaw":
                foodDetails yeet = new foodDetails("res/holiaw_food.jpeg","Holiaw",30_000,"<HTML> Jl. Raya Klp. Kopyor No.19 Blok Q1, RT.11/RW.19, Klp. Gading Tim., Kec. Klp. Gading, Jkt Utara, Daerah Khusus Ibukota Jakarta 14240</HTML>",
                        "5.0 KM","Non-Halal","Noodles","4.87","Holiaw","<HTML> A noodle place with a simple decor that is popular for its Grilled Pork Noodles, mixed rice, and others. </HTML>",
                        "<HTML>Mie Siobak (1 porsi) <br/> Bakso Goreng (1 porsi) <br/> Mie Campur (1 porsi) </HTML>");
                backButton.viewStack.push(homePage.homeFrame);
                break;
            case "Ragusa Es Italia":
                foodDetails jeez = new foodDetails("res/gambarEskrim.png","Ragusa Es Italia",10_000,"<HTML>Jl. Veteran I No.10, RT.4/RW.2, Gambir, Kecamatan Gambir, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10110</HTML>","4.07 KM","Halal","Ice Cream","4.8","Paket Surplus Ragusa",
                        "<HTML>Ice cream parlor serving a variety of creative desserts in a cozy space with a retro vibe. You can buy Ragusa’s surplus items inside wrapped inside a bag. </HTML>",
                            "<HTML>Banana Split Ice Cream (1 porsi) <br/> Spaghetti Ice Cream (1 porsi) <br/> Random Fruit Jams (1 pcs)");
                homePage.homeFrame.dispose();
                backButton.viewStack.push(homePage.homeFrame);
                break;
        }
    }
}
