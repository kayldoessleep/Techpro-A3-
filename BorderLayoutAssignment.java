import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutAssignment {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout Assignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        frame.setLayout(new BorderLayout());

        frame.add(new JButton("North"), BorderLayout.NORTH);
        frame.add(new JButton("South"), BorderLayout.SOUTH);
        frame.add(new JButton("East"),  BorderLayout.EAST);
        frame.add(new JButton("West"),  BorderLayout.WEST);
        frame.add(new JButton("Center"),BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
