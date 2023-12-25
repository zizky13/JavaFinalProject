import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class foodDetails {

    static JFrame restoFrame;
    keranjangPage test;



    JPanel restoPanel, vendorPanel, descPanel, buttonPanel, addToCartPanel,backPanel;
    JLabel judul, foodDescription,whatInside,contentMakanan,sisaStok;
    backButton back = new backButton();
    ImageIcon filePhoto,resizedIcon;
    Font normalFont = new Font("Helvetica", Font.PLAIN, 12);
    Font superFont = new Font ("Helvetica", Font.BOLD,14);

    public foodDetails(String photoPath) { //can be added parameters for sellers perspective

        //======================= RESTO FRAME INIT ========================
        restoFrame = new JFrame("Food Details");
        restoFrame.setSize(400,720);
        restoFrame.setBackground(Color.white);
        restoFrame.setLayout(null);
        restoFrame.setVisible(true);

        //======================= INSERTING IMAGE TO RESTO PANEL ========================
        filePhoto = new ImageIcon(photoPath);
        Image resizedPhoto = filePhoto.getImage().getScaledInstance(400,144,Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizedPhoto);
        JLabel photo = new JLabel(resizedIcon);
        photo.setBounds(0,0,400,136); //descPanel height remain = 252 - 86 = 166

        //======================= VENDOR NAME INIT ========================
        JLabel vendorName = new JLabel("Ragusa");
        vendorName.setBounds(0,137,100,15); //descPanel height remain = 166 - 15 = 151

        //======================= PRICE INIT ========================
        int price = 10_500;
        JLabel harga = new JLabel("Rp. " + price);
        harga.setBounds(0, 153, 400, 15);

        //======================= VENDOR ADDRESS INIT ========================
        //use <HTML> tag for line break
        JLabel vendorAddress = new JLabel("<HTML>Jl. Veteran I No.10, RT.4/RW.2, Gambir, Kecamatan Gambir, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10110</HTML>");
        vendorAddress.setBounds(0, 168,300, 54); //descPanel height remain = 151 - 34 = 117
        vendorAddress.setFont(normalFont);

        //======================= VENDOR DISTANCE INIT ========================
        JLabel vendorDistance = new JLabel("4.03 KM");
        vendorDistance.setBounds(300,137,100,34); //descPanel height remain = 151 - 34 = 117
        vendorDistance.setFont(normalFont);

        //======================= HALAL TAG INIT ========================
        JLabel halalTag = new JLabel("Halal");
        halalTag.setOpaque(true);
        halalTag.setBackground(Color.green);
        halalTag.setBounds(0, 228, 100, 15); //descPanel height remain = 117 - 15 = 102

        //======================= FOOD TYPE INIT ========================
        JLabel foodTypeTag = new JLabel("Es Krim");
        foodTypeTag.setOpaque(true);
        foodTypeTag.setForeground(Color.white);
        foodTypeTag.setBackground(Color.blue);
        foodTypeTag.setBounds(110, 228, 100, 15); //descPanel height remain = 117 - 15 = 102


        //======================= RATING INIT ========================
        JLabel ratingTag = new JLabel("4.7⭐");
        ratingTag.setOpaque(true);
        ratingTag.setBackground(Color.yellow);
        ratingTag.setBounds(220, 228, 100, 15); //descPanel height remain = 117 - 15 = 52

        //======================= VENDOR PANEL INIT AND ADD COMPONENT ========================
        vendorPanel = new JPanel();
        vendorPanel.setLayout(null);
        vendorPanel.setBounds(0,0,400,247);//maximum height 252 (35%), object exceed this value will not be drawn
        vendorPanel.add(photo);
        vendorPanel.add(vendorName);
        vendorPanel.add(harga);
        vendorPanel.add(vendorAddress);
        vendorPanel.add(vendorDistance);
        vendorPanel.add(halalTag);
        vendorPanel.add(foodTypeTag);
        vendorPanel.add(ratingTag);
        vendorPanel.setBackground(new Color(86,158,158));


        //======================= DESC PANEL INIT AND ADD COMPONENT ========================
        descPanel = new JPanel();
        descPanel.setLayout(null);
        descPanel.setBounds(0,253,400,196); //30%
        descPanel.setBackground(new Color(86,158,158));


        //======================= JUDUL FOOD DESCRIPTION INIT ========================
        judul = new JLabel("Food Description:");
        judul.setFont(superFont);
        judul.setBounds(0, 0, 400, 14); // Sisa height = 216 - 24 = 192

        //======================= FOOD DESCRIPTION INIT ========================
        foodDescription = new JLabel("<HTML>Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum </HTML>");
        foodDescription.setBounds(0, 18, 400,92); // Sisa height = 192 - 92 = 100
        foodDescription.setVerticalAlignment(JLabel.TOP);

        //======================= WHAT'S INSIDE INIT ========================
        whatInside = new JLabel("What's Inside?");
        whatInside.setBounds(0,106, 400,24); // Sisa height = 100 - 24 = 76


        //======================= FOOD CONTENT INIT ========================
        contentMakanan = new JLabel("<html> - Es Krim Jeruk <br> - Es Krim Kelapa </html>");
        contentMakanan.setBounds(5,130, 395,60); // Sisa height = 76 -14 = 62
        contentMakanan.setVerticalAlignment(JLabel.TOP);

        //======================= ADDING TO DESC PANEL ========================
        descPanel.add(judul);
        descPanel.add(foodDescription);
        descPanel.add(whatInside);
        descPanel.add(contentMakanan);

        //======================= SISA STOCK INIT ========================
        sisaStok = new JLabel("Sisa stok adalah: ", SwingConstants.CENTER);
        sisaStok.setBounds(0,452,400,10);
        restoFrame.add(sisaStok);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(Color.white);
        buttonPanel.setBounds(100, 469,200, 36);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Helvetica", Font.PLAIN, 24));
        minus.setBounds(0, 0, 50,36);
        minus.setFocusPainted(false);
        minus.setBackground(new Color(86,158,158));

        JLabel counter = new JLabel("1", SwingConstants.CENTER);
        counter.setBounds(50,0,100,36);

        JButton plus = new JButton("+");
        plus.setFont(new Font("Helvetica", Font.PLAIN, 20));
        plus.setBounds(150, 0, 50,36);
        plus.setFocusPainted(false);
        plus.setBackground(new Color(86,158,158));

        buttonPanel.add(minus);
        buttonPanel.add(counter);
        buttonPanel.add(plus);

        addToCartPanel = new JPanel();
        addToCartPanel.setLayout(null);
        addToCartPanel.setBounds(100,515,200,54);

        // ================================= BACK BUTTON =============================
        backPanel = new JPanel();
        back = new backButton();
        backPanel.setLayout(new GridLayout());
        backPanel.setBounds(0,0, 30,30);
        backPanel.add(back.backPanel);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!backButton.viewStack.isEmpty()){
                    JFrame prevFrame = backButton.viewStack.peek();
                    prevFrame.setVisible(true);
                    restoFrame.dispose();
                    backButton.viewStack.pop();
                } else {
                    System.out.println("Stack is empty");
                }
            }
        });

        JButton addToCartButton = new JButton(resized("res/AddToCartButton.png"));
        addToCartButton.setBounds(0,0,200,54);
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButton.viewStack.push(restoFrame);
            }
        });

        addToCartPanel.add(addToCartButton);

        vendorPanel.setComponentZOrder(backPanel,0);
        restoFrame.add(vendorPanel);
        restoFrame.add(descPanel);
        restoFrame.add(buttonPanel);
        restoFrame.add(addToCartPanel);
        restoFrame.add(backPanel);

        navBar navButton = new navBar(restoFrame);



        //TO DO:
        // 1. tambah button paling bawah
        // 2. ganti semua layout page jadi null
        // 3. button paling bawah -> universal button, buat satu class baru
    }


    private ImageIcon resized(String photoPath){
        ImageIcon photo = new ImageIcon(photoPath);
        Image userPhoto = photo.getImage().getScaledInstance(200, 54, Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(userPhoto);
    }
    private ImageIcon resized(String photoPath, int Width, int Height){
        ImageIcon photo = new ImageIcon(photoPath);
        Image userPhoto = photo.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
        return new ImageIcon(userPhoto);
    }
}
