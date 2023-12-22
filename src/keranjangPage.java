import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class keranjangPage {

    JPanel deliveryPanel, orderPanel,itemPanel, backPanel;
    JButton backButt;
    orderCard card;
    public keranjangPage(){
        JFrame keranjangFrame = new JFrame("Keranjang");
        keranjangFrame.setSize(400,720);
        keranjangFrame.setVisible(true);
        keranjangFrame.setLayout(null);

        // delivery panel
        deliveryPanel = new JPanel();
        deliveryPanel.setBounds(0,0,400,130);
        deliveryPanel.setBackground(Color.red);
        deliveryPanel.setLayout(null);

        //order panel
        orderPanel = new JPanel();
        orderPanel.setBounds(0,140,400,216);
        orderPanel.setBackground(Color.red);
        orderPanel.setLayout(null);


        //delivery panel components #1
        JLabel userName = new JLabel("Dimas");
        userName.setBounds(10,35,400,15); // 50

        //delivery panel components #2
        JLabel location = new JLabel("<html>Jl. Veteran I No.10, RT.4/RW.2, Gambir, Kecamatan Gambir, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10110</html>");
        location.setBounds(10,55,400,32); // 82

        //delivery panel components #3
        String[] options = {"Gojek", "Grab"};
        JComboBox<String> deliveryOption = new JComboBox<>(options);
        deliveryOption.setBounds(10,92,100,35);// 117

        //order panel components #1
        itemPanel = new JPanel();
        itemPanel.setLayout(new GridLayout(3,0));

        backPanel = new JPanel();
        backButt = new JButton("Balik");
        backPanel.setLayout(new GridLayout());
        backPanel.setBounds(0,0, 30,30);
        backPanel.add(backButt);
        deliveryPanel.setComponentZOrder(backPanel,0);
        keranjangFrame.add(backPanel);

        deliveryPanel.add(userName);
        deliveryPanel.add(location);
        deliveryPanel.add(deliveryOption);
        keranjangFrame.add(deliveryPanel);
        keranjangFrame.add(orderPanel);

        //delivery component listener
        deliveryOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<?> source = (JComboBox<?>) e.getSource();
                String selectedOption = (String) source.getSelectedItem();
                System.out.println("Selected: " + selectedOption);
            }
        });
    }

    public void tambahOrder(){
        itemPanel.add(card.orderPanel);
    }

    public static void main(String[] args) {
        keranjangPage tampil = new keranjangPage();
    }
}
