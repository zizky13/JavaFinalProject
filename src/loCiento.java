import javax.swing.*;
import java.awt.*;

public class loCiento {
    static JFrame restoFrame;
    JPanel restoPanel;
    JTextArea deskripsi;

    public loCiento(){
        restoFrame = new JFrame();
        restoPanel = new JPanel();
        restoPanel.setBackground(Color.red);
        restoFrame.add(restoPanel);
        restoFrame.setVisible(true);
    }

    public static void openResto(){
    }
}
