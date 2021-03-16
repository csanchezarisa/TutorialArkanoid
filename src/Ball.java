import assets.sonidos.Sound;

import java.awt.*;

public class Ball {

    private static final int DIAMETER = 30;

    int x;
    int y = DIAMETER;
    int xa = 1;
    int ya = 1;
    private Game game;

    public Ball(Game game) {
        this.game = game;
        x = (int) (Math.random() * (game.getWidth()));
    }

    public void move() {
        boolean changeDirection = true;

        if (x + xa < 0)
            xa = game.speed;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if (y + ya < 0)
            ya = game.speed;
        else if (y + ya > game.getHeight() - DIAMETER)
            ya = -game.speed;
            //game.gameOver();
        else if (collision()) {
            ya = -game.speed;
            y = game.racquet.getTopY() - DIAMETER;
            //game.speed++;
        }
        else if (maoCollision()) {
            ya = game.speed;
            y = game.mao.y + DIAMETER;
            game.mao.tocado();
        }
        else
            changeDirection = false;

        if (changeDirection)
            Sound.BALL.play();

        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    private boolean maoCollision() {
        return game.mao.getBounds().intersects(getBounds()) && !game.mao.cayendo;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
