import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeatingHeartAnimation extends JPanel {
    private double heartScale; // Scale factor for the heart
    private int direction; // 1 for expanding, -1 for contracting

    public BeatingHeartAnimation() {
        heartScale = 1.0; // Initial scale
        direction = 1; // Start expanding

        // Create a timer to update the animation
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the heart's scale
                heartScale += 0.01 * direction;

                // Reverse direction when heart reaches certain size
                if (heartScale >= 1.2 || heartScale <= 0.8) {
                    direction *= -1;
                }

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

        // Draw the heart shape
        g2d.setColor(Color.RED);
        int heartWidth = 50;
        int heartHeight = 50;
        int x = centerX - heartWidth / 2;
        int y = centerY - heartHeight / 2;
        g2d.scale(heartScale, heartScale);
        g2d.fillArc(x, y, heartWidth, heartHeight, 0, 180);
        g2d.fillArc(x - heartWidth / 2, y, heartWidth, heartHeight, 0, 180);

        // Draw the line (path for heart movement)
        g2d.setColor(Color.BLACK);
        g2d.drawLine(50, centerY, getWidth() - 50, centerY);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Beating Heart Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(new BeatingHeartAnimation());
        frame.setVisible(true);
    }
}
