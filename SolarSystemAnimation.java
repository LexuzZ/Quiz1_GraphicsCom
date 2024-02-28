import java.awt.*;
import javax.swing.*;

public class SolarSystemAnimation {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawSolarSystem(g);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void drawSolarSystem(Graphics g) {
        int sunX = 400; // Sun's position (center)
        int sunY = 300;
        int planetRadius = 10;
        int orbitRadius = 200;

        // Calculate angle for one-third of the orbit
        double totalAngle = 2 * Math.PI; // Full orbit
        double oneThirdAngle = totalAngle / 3.0;

        // Calculate new position after one-third of the orbit
        int planetX = (int) (sunX + orbitRadius * Math.cos(oneThirdAngle));
        int planetY = (int) (sunY + orbitRadius * Math.sin(oneThirdAngle));

        // Draw sun (yellow circle)
        g.setColor(Color.YELLOW);
        g.fillOval(sunX - planetRadius, sunY - planetRadius, 2 * planetRadius, 2 * planetRadius);

        // Draw planet (green circle)
        g.setColor(Color.GREEN);
        g.fillOval(planetX - planetRadius, planetY - planetRadius, 2 * planetRadius, 2 * planetRadius);

        // Draw line connecting sun and planet
        g.setColor(Color.BLACK);
        g.drawLine(sunX, sunY, planetX, planetY);
    }
}
