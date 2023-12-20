import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ragusa {

    JFrame restoFrame;
    keranjangPage test;

    JPanel restoPanel, descPanel, descPanel2, buttonPanel, addToCartPanel;
    ImageIcon filePhoto,resizedIcon;
    Font normalFont = new Font("Helvetica", Font.PLAIN, 12);
    Font superFont = new Font ("Helvetica", Font.BOLD,14);

    public ragusa () {
        restoFrame = new JFrame();
        restoFrame.setSize(400,720);
        restoFrame.setBackground(Color.white);
        restoFrame.setLayout(null);
        restoFrame.setVisible(true);

        String photoPath = "res/logo_UPJ.png";
        filePhoto = new ImageIcon(photoPath);
        Image resizedPhoto = filePhoto.getImage().getScaledInstance(400,144,Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizedPhoto);
        JLabel photo = new JLabel(resizedIcon);
        photo.setBounds(0,0,400,136); //descPanel height remain = 252 - 86 = 166

        JLabel vendorName = new JLabel("Ragusa");
        vendorName.setBounds(0,137,100,15); //descPanel height remain = 166 - 15 = 151

        int price = 10_500;
        JLabel harga = new JLabel("Rp. " + price);
        harga.setBounds(0, 153, 400, 15);

        //use <HTML> tag for line break
        JLabel vendorAddress = new JLabel("<HTML>Jl. Veteran I No.10, RT.4/RW.2, Gambir, Kecamatan Gambir, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10110</HTML>");
        vendorAddress.setBounds(0, 168,300, 54); //descPanel height remain = 151 - 34 = 117
        vendorAddress.setFont(normalFont);

        JLabel vendorDistance = new JLabel("4.03 KM");
        vendorDistance.setBounds(300,137,100,34); //descPanel height remain = 151 - 34 = 117
        vendorDistance.setFont(normalFont);

        JLabel halalTag = new JLabel("Halal");
        halalTag.setOpaque(true);
        halalTag.setBackground(Color.green);
        halalTag.setBounds(0, 228, 100, 15); //descPanel height remain = 117 - 15 = 102

        JLabel foodTypeTag = new JLabel("Es Krim");
        foodTypeTag.setOpaque(true);
        foodTypeTag.setForeground(Color.white);
        foodTypeTag.setBackground(Color.blue);
        foodTypeTag.setBounds(110, 228, 100, 15); //descPanel height remain = 117 - 15 = 102


        JLabel ratingTag = new JLabel("4.7⭐");
        ratingTag.setOpaque(true);
        ratingTag.setBackground(Color.yellow);
        ratingTag.setBounds(220, 228, 100, 15); //descPanel height remain = 117 - 15 = 52

        descPanel = new JPanel();
        descPanel.setLayout(null);
        descPanel.setBounds(0,0,400,252);//maximum height 252 (35%), object exceed this value will not be drawn
        descPanel.add(photo);
        descPanel.add(vendorName);
        descPanel.add(harga);
        descPanel.add(vendorAddress);
        descPanel.add(vendorDistance);
        descPanel.add(halalTag);
        descPanel.add(foodTypeTag);
        descPanel.add(ratingTag);
        descPanel.setBackground(Color.lightGray);

        descPanel2 = new JPanel();
        descPanel2.setLayout(null);
        descPanel2.setBounds(0,253,400,196); //30%
        descPanel2.setBackground(Color.red);

        JLabel judul = new JLabel("Food Description:");
        judul.setFont(superFont);
        judul.setBounds(0, 0, 400, 14); // Sisa height = 216 - 24 = 192

        JLabel foodDescription = new JLabel("<HTML>Lorem Ipsum Kontol Bada Memek pepek anjing pukimai cuki Lorem Ipsum Kontol Bada Memek pepek anjing pukimai cuki Lorem Ipsum Kontol Bada Memek pepek anjing pukimai cuki Lorem Ipsum Kontol Bada Memek pepek anjing pukimai cuki </HTML>");
        foodDescription.setBounds(0, 0, 400,92); // Sisa height = 192 - 92 = 100

        JLabel whatInside = new JLabel("What Inside?");
        whatInside.setBounds(0,106, 400,24); // Sisa height = 100 - 24 = 76

        JLabel contentMakanan = new JLabel(" - Kontol badak");
        contentMakanan.setBounds(0,140, 400,14); // Sisa height = 76 -14 = 62

        descPanel2.add(judul);
        descPanel2.add(foodDescription);
        descPanel2.add(whatInside);
        descPanel2.add(contentMakanan);

        JLabel sisaStok = new JLabel("Sisa stok adalah: ajsdfhasohfoaowehfkladsfklajfklajfw", SwingConstants.CENTER);
        sisaStok.setBounds(0,452,400,10);
        restoFrame.add(sisaStok);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(Color.red);
        buttonPanel.setBounds(100, 469,200, 36);

        JButton minus = new JButton("-");
        minus.setBounds(0, 0, 50,36);
        minus.setBackground(Color.green);
        minus.setForeground(Color.white);
        minus.setFocusPainted(false);

        JLabel counter = new JLabel("1", SwingConstants.CENTER);
        counter.setBounds(50,0,100,36);

        JButton plus = new JButton("+");
        plus.setBounds(150, 0, 50,36);
        plus.setBackground(Color.green);
        plus.setForeground(Color.white);
        plus.setFocusPainted(false);

        buttonPanel.add(minus);
        buttonPanel.add(counter);
        buttonPanel.add(plus);

        addToCartPanel = new JPanel();
        addToCartPanel.setLayout(null);
        addToCartPanel.setBounds(100,515,200,54);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setBounds(0,0,200,54);
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test.tambahOrder();
            }
        });

        addToCartPanel.add(addToCartButton);

        restoFrame.add(descPanel);
        restoFrame.add(descPanel2);
        restoFrame.add(buttonPanel);
        restoFrame.add(addToCartPanel);

        navBar navButton = new navBar(restoFrame);


        //TO DO:
        // 1. tambah button paling bawah
        // 2. ganti semua layout page jadi null
        // 3. button paling bawah -> universal button, buat satu class baru
    }
}
