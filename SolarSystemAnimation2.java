import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolarSystemAnimation2 extends JPanel {
    private double planetAngle; // Angle of rotation around the sun
    private final double planetOrbitRadius = 200.0; // Radius of the planet's orbit
    private final double planetRadius = 10.0; // Radius of the planet itself

    public SolarSystemAnimation2() {
        planetAngle = 0.0; // Initialize the angle

        // Create a timer to update the animation
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the planet's angle (one-third of the orbit)
                planetAngle += (2 * Math.PI) / 3.0;
                repaint(); // Redraw the scene
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set up the coordinate system
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Calculate the planet's position
        int planetX = (int) (centerX + planetOrbitRadius * Math.cos(planetAngle));
        int planetY = (int) (centerY + planetOrbitRadius * Math.sin(planetAngle));

        // Draw the sun (yellow circle)
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(centerX - 5, centerY - 5, 10, 10);

        // Draw the planet (green circle)
        g2d.setColor(Color.GREEN);
        g2d.fillOval(planetX - (int) planetRadius, planetY - (int) planetRadius,
                (int) (2 * planetRadius), (int) (2 * planetRadius));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new SolarSystemAnimation2());
        frame.setVisible(true);
    }
}
