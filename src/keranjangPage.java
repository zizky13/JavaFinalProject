import javax.swing.*;
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
        userName.setBounds(10,40,400,15);

        //delivery panel components #2
        JLabel location = new JLabel("<html>Jl. Veteran I No.10, RT.4/RW.2, Gambir, Kecamatan Gambir, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10110</html>");
        location.setBounds(10,85,400,32);

        //delivery panel components #3
        String[] options = {"Gojek", "Grab"};
        JComboBox<String> deliveryOption = new JComboBox<>(options);
        deliveryOption.setBounds(10,60,100,35);

        //order panel components #1
        itemPanel = new JPanel();
        itemPanel.setLayout(new GridLayout(3,0));

        backPanel = new JPanel();
        back = new backButton();
        backPanel.setLayout(new GridLayout());
        backPanel.setBounds(0,0, 30,30);
        deliveryPanel.setComponentZOrder(backPanel,0);
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

        backPanel.add(back);
        deliveryPanel.add(userName);
        deliveryPanel.add(location);
        deliveryPanel.add(deliveryOption);
        keranjangFrame.add(backPanel);
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
}
