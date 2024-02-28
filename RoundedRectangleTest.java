import java.awt.*;
import java.awt.geom.GeneralPath;

import javax.swing.*;

public class RoundedRectangleTest extends JFrame {
    public RoundedRectangleTest() {
        setTitle("Rounded Rectangle Test");
        setSize(350, 275);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create a rounded rectangle using GeneralPath
        GeneralPath roundedRect = new GeneralPath();
        int x = 50; // Top-left corner x-coordinate
        int y = 50; // Top-left corner y-coordinate
        int width = 150; // Rectangle width
        int height = 100; // Rectangle height
        int cornerRadius = 20; // Radius for rounded corners

        roundedRect.moveTo(x + cornerRadius, y);
        roundedRect.lineTo(x + width - cornerRadius, y);
        roundedRect.quadTo(x + width, y, x + width, y + cornerRadius);
        roundedRect.lineTo(x + width, y + height - cornerRadius);
        roundedRect.quadTo(x + width, y + height, x + width - cornerRadius, y + height);
        roundedRect.lineTo(x + cornerRadius, y + height);
        roundedRect.quadTo(x, y + height, x, y + height - cornerRadius);
        roundedRect.lineTo(x, y + cornerRadius);
        roundedRect.quadTo(x, y, x + cornerRadius, y);
        roundedRect.closePath();

        g2d.draw(roundedRect); // Draw the rounded rectangle
    }

    public static void main(String[] args) {
        new RoundedRectangleTest();
    }
}
