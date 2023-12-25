import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class backButton extends JButton {
    JPanel backPanel;
    JButton back;
    public static Stack<JFrame> viewStack;
    public backButton(){
        viewStack = new Stack<>();
        backPanel = new JPanel();
        back = new JButton();
        backPanel.setLayout(new GridLayout());
        backPanel.setBounds(0,0, 30,30);
        backPanel.add(back);
    }
}
