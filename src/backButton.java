import javax.swing.*;
import java.awt.*;

public class backButton extends Component {
    JPanel backPanel;
    public backButton(){
        backPanel = new JPanel();
        JButton backButt = new JButton("Balik");
        backPanel.setLayout(new GridLayout());
        backPanel.setBounds(0,0, 30,30);
        backPanel.add(backButt);
    }
}
