import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShootingGameGraphics extends JFrame {

    public ShootingGameGraphics() {
        setTitle("Shooting Game with Mouse & Graphics");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        GamePanel panel = new GamePanel();
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShootingGameGraphics().setVisible(true);
        });
    }
}

class GamePanel extends JPanel {
    private volatile boolean isHit = false;
    private Point target;
    private String resultMessage = "Click to shoot! 🎯";
    private Point bulletStart = null;
    private Point bulletEnd = null;

    public GamePanel() {
        setBackground(Color.BLACK);
        // Random target in center region
        target = new Point(250 + (int)(Math.random() * 100), 150 + (int)(Math.random() * 100));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Thread(() -> shoot(e.getPoint())).start();
            }
        });
    }

    private synchronized void shoot(Point clickPoint) {
        bulletStart = new Point(getWidth() / 2, getHeight()); // from bottom center
        bulletEnd = clickPoint;

        // Repaint to show bullet line
        repaint();

        // Check hit (simple circle around target)
        int radius = 30;
        if (!isHit && clickPoint.distance(target) <= radius) {
            isHit = true;
            resultMessage = "💥 You hit the target!";
        } else if (!isHit) {
            resultMessage = "❌ Missed...";
        } else {
            resultMessage = "Too late! Someone already hit!";
        }

        try {
            Thread.sleep(500); // show bullet briefly
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        bulletStart = null;
        bulletEnd = null;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw target
        g.setColor(Color.RED);
        g.fillOval(target.x - 30, target.y - 30, 60, 60);

        // Draw bullet line
        if (bulletStart != null && bulletEnd != null) {
            g.setColor(Color.YELLOW);
            ((Graphics2D) g).setStroke(new BasicStroke(3));
            g.drawLine(bulletStart.x, bulletStart.y, bulletEnd.x, bulletEnd.y);
        }

        // Draw result
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString(resultMessage, 20, 30);
    }
}
