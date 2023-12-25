import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class keranjangPage {

    JPanel deliveryPanel, orderPanel,itemPanel, backPanel;
    backButton back = new backButton();
    orderCard card;
    static JFrame keranjangFrame;
    public keranjangPage(){
        keranjangFrame = new JFrame("Keranjang");
        keranjangFrame.setSize(400,720);
        keranjangFrame.setVisible(true);
        keranjangFrame.setLayout(null);

        // delivery panel
        deliveryPanel = new JPanel();
        deliveryPanel.setBounds(0,40,400,130);
        deliveryPanel.setBackground(new Color(86,158,158));
        deliveryPanel.setLayout(null);

        //order panel
        orderPanel = new JPanel();
        orderPanel.setBounds(0,180,400,216);
        orderPanel.setBackground(new Color(86,158,158));
        orderPanel.setLayout(null);


        //delivery panel components #1
        JLabel userName = new JLabel("Dimas");
        userName.setBounds(10,5,400,15); // 20

        //delivery panel components #2
        JLabel location = new JLabel("<html>Jl. Veteran I No.10, RT.4/RW.2, Gambir, Kecamatan Gambir, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10110</html>");
        location.setBounds(10,25,400,32); // 57

        //delivery panel components #3
        String[] options = {"Gojek", "Grab"};
        JComboBox<String> deliveryOption = new JComboBox<>(options);
        deliveryOption.setBounds(10,67,100,35);// 102

        //order panel components #1
        itemPanel = new JPanel();
        itemPanel.setLayout(new GridLayout(3,0));

        // BackButton
        backPanel = new JPanel();
        back = new backButton();
        backPanel.setLayout(new GridLayout());
        backPanel.setBounds(0,0, 30,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!backButton.viewStack.isEmpty()){
                    JFrame prevFrame = backButton.viewStack.peek();
                    prevFrame.setVisible(true);
                    keranjangFrame.dispose();
                    backButton.viewStack.pop();
                } else {
                    System.out.println("Stack is empty");
                }
            }
        });

        backPanel.add(back.backPanel);
        JLabel harga = new JLabel("Subtotal Order:", SwingConstants.CENTER);
        harga.setFont(new Font("helvetica", Font.PLAIN,24));
        harga.setBounds(25,420,350,40);
        harga.setBorder(BorderFactory.createLineBorder(new Color(86,158,158), 3));

        String[] pembayaran = {"Gojek", "Grab"};
        JComboBox<String> pembayaranOption = new JComboBox<>(pembayaran);
        pembayaranOption.setBounds(25,470,350,40);
        pembayaranOption.setFont(new Font("helvetica", Font.PLAIN,24));

        // Untuk align center teks pada ComboBox
        BasicComboBoxRenderer renderer = new BasicComboBoxRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        pembayaranOption.setRenderer(renderer);

        JButton bayarButton = new JButton("Pay");
        bayarButton.setBackground(new Color(86,158,158));
        bayarButton.setFont(new Font("helvetica", Font.PLAIN,24));
        bayarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        bayarButton.setBounds(25,530,350,60);


        deliveryPanel.add(userName);
        deliveryPanel.add(location);
        deliveryPanel.add(deliveryOption);
        keranjangFrame.add(harga);
        keranjangFrame.add(pembayaranOption);
        keranjangFrame.add(bayarButton);
        keranjangFrame.add(backPanel);
        keranjangFrame.add(deliveryPanel);
        keranjangFrame.add(orderPanel);

        navBar nav = new navBar(keranjangFrame);
        //delivery component listener
        deliveryOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<?> source = (JComboBox<?>) e.getSource();
                String selectedOption = (String) source.getSelectedItem();
                System.out.println("Selected: " + selectedOption);
            }
        });

        pembayaranOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<?> source = (JComboBox<?>) e.getSource();
                String selectedOption = (String) source.getSelectedItem();
                System.out.println("Selected: " + selectedOption);
            }
        });
    }


}
