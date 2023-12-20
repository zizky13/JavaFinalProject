import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class keranjangPage {

    JPanel deliveryPanel, orderPanel,itemPanel;
    JFrame keranjangFrame;
    orderCard card;
    public keranjangPage(){
        keranjangFrame = new JFrame();
        keranjangFrame.setSize(400,720);
        keranjangFrame.setVisible(true);
        keranjangFrame.setLayout(null);

        // delivery panel
        deliveryPanel = new JPanel();
        deliveryPanel.setBounds(0,0,400,108);
        deliveryPanel.setBackground(Color.red);
        deliveryPanel.setLayout(null);

        //order panel
        orderPanel = new JPanel();
        orderPanel.setBounds(0,118,400,216);
        orderPanel.setBackground(Color.red);
        orderPanel.setLayout(null);


        //delivery panel components #1
        JLabel userName = new JLabel("Dimas");
        userName.setBounds(10,10,400,15);

        //delivery panel components #2
        JLabel location = new JLabel("<html>Jl. Veteran I No.10, RT.4/RW.2, Gambir, Kecamatan Gambir, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10110</html>");
        location.setBounds(10,25,400,32);

        //delivery panel components #3
        String[] options = {"Gojek", "Grab"};
        JComboBox<String> deliveryOption = new JComboBox<>(options);
        deliveryOption.setBounds(10,60,100,35);

        //order panel components #1
        itemPanel = new JPanel();
        orderPanel.add(itemPanel);
        itemPanel.setBounds(0,0,400,180);
        itemPanel.setLayout(new GridLayout(3,0));


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
        itemPanel.add(new JButton("test"));
        keranjangFrame.repaint();
    }

    public JPanel getItemPanel(){
        return itemPanel;
    }

}
