public class ShootingGame {
    public static void main(String[] args) {
        Target target = new Target();

        Shooter s1 = new Shooter("Player 1", target);
        Shooter s2 = new Shooter("Player 2", target);
        Shooter s3 = new Shooter("Player 3", target);

        s1.start();
        s2.start();
        s3.start();
    }
}

class Target {
    private volatile boolean isHit = false;

    public synchronized boolean shoot(String playerName) {
        if (!isHit) {
            isHit = true;
            System.out.println(playerName + " hit the target! 🏆");
            return true;
        } else {
            System.out.println(playerName + " missed... Target already hit! ❌");
            return false;
        }
    }
}

class Shooter extends Thread {
    private String playerName;
    private Target target;

    public Shooter(String playerName, Target target) {
        this.playerName = playerName;
        this.target = target;
    }

    @Override
    public void run() {
        try {
            // Simulate different reaction times
            int reactionTime = (int) (Math.random() * 1000);
            Thread.sleep(reactionTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        target.shoot(playerName);
    }
}
