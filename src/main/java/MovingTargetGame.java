import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MovingTargetGame extends JFrame {

    public MovingTargetGame() {
        setTitle("Moving Target Shooting Game");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        GamePanel1 panel = new GamePanel1();
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MovingTargetGame().setVisible(true);
        });
    }
}

class GamePanel1 extends JPanel {
    private volatile boolean isHit = false;
    private Point target = new Point(100, 100);
    private int targetRadius = 30;
    private String resultMessage = "🎯 Shoot the moving target!";
    private Point bulletStart = null;
    private Point bulletEnd = null;
    private Timer moveTimer;
    private Random rand = new Random();

    public GamePanel1() {
        setBackground(Color.BLACK);

        // Move the target every 500 ms
        moveTimer = new Timer(500, e -> {
            if (!isHit) {
                int x = rand.nextInt(getWidth() - 2 * targetRadius) + targetRadius;
                int y = rand.nextInt(getHeight() - 2 * targetRadius) + targetRadius;
                target.setLocation(x, y);
                repaint();
            }
        });
        moveTimer.start();

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
        repaint();

        // Check if click is within target
        if (!isHit && clickPoint.distance(target) <= targetRadius) {
            isHit = true;
            resultMessage = "💥 You hit the target!";
            moveTimer.stop(); // Stop moving after hit
        } else if (!isHit) {
            resultMessage = "❌ Missed... Try again!";
        } else {
            resultMessage = "Too late! Already hit!";
        }

        try {
            Thread.sleep(500); // bullet effect delay
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

        // Draw the moving target
        g.setColor(Color.RED);
        g.fillOval(target.x - targetRadius, target.y - targetRadius, targetRadius * 2, targetRadius * 2);

        // Draw bullet
        if (bulletStart != null && bulletEnd != null) {
            g.setColor(Color.YELLOW);
            ((Graphics2D) g).setStroke(new BasicStroke(3));
            g.drawLine(bulletStart.x, bulletStart.y, bulletEnd.x, bulletEnd.y);
        }

        // Draw status message
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(resultMessage, 20, 30);
    }
}
