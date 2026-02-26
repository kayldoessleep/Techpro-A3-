import javax.swing.*;

public class FlowLayoutAssignment {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Assignment");
        frame.setSize(300, 200);
        frame.setLayout(new java.awt.FlowLayout());

        frame.add(new JButton("Button 1"));
        frame.add(new JButton("Button 2"));
        frame.add(new JButton("Button 3"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
