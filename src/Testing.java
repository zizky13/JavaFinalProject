import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Testing extends JPanel {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new Testing());
        f.setSize(800, 800);
        f.setVisible(true);
    }

    public Testing() {
        setLayout(null);
        JButton first = new JButton("This button is added first");
        first.setBounds(20, 50, 200, 30);
        add(first);
        JButton second = new JButton("This button is added second");
        second.setBounds(120, 65, 200, 30);
        add(second);
    }

}