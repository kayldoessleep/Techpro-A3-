import javax.swing.JButton;
import javax.swing.JFrame;

public class AbsolutePositioningAssignment {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Absolute Positioning Assignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        frame.setLayout(null);

        JButton btn1 = new JButton("Button 1");
        btn1.setBounds(50, 50, 150, 40);

        JButton btn2 = new JButton("Button 2");
        btn2.setBounds(150, 120, 150, 40);

        frame.add(btn1);
        frame.add(btn2);

        frame.setVisible(true);
    }
}
