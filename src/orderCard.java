import javax.swing.*;
import java.awt.*;

public class orderCard {

    String vendorName;
    float orderPrice;
    JPanel orderPanel;
    ImageIcon icon;
    keranjangPage page;

    public orderCard(){

        orderPanel = new JPanel();
        orderPanel.setBackground(Color.blue);

        page.itemPanel.add(orderPanel);
    }
}
