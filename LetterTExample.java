import javax.swing.*;
import java.awt.*;

public class LetterTExample extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set font and size
        Font font = new Font("Arial", Font.BOLD, 50);
        g2d.setFont(font);

        // Draw the letter "T"
        g2d.drawString("T", 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Letter T Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(new LetterTExample());
        frame.setVisible(true);
    }
}
