import javax.swing.*;
import java.awt.*;

public class LetterHExample extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set font and size
        Font font = new Font("Arial", Font.BOLD, 50);
        g2d.setFont(font);

        // Draw the letter "H"
        g2d.drawString("H", 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Letter H Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(new LetterHExample());
        frame.setVisible(true);
    }
}
