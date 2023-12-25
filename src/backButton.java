import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class backButton extends JButton {
    JPanel backPanel;
    JButton kembali;
    public static Stack<JFrame> viewStack;
    public backButton(){
        viewStack = new Stack<>();
        backPanel = new JPanel();
        kembali = new JButton(resized());
        backPanel.setLayout(new GridLayout());
        backPanel.setBounds(0,0, 30,30);
        backPanel.add(kembali);
    }

    private ImageIcon resized(){
        ImageIcon photo = new ImageIcon("res/BackButton.png");
        Image userPhoto = photo.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(userPhoto);
    }
}
