import java.awt.*;

public class Mao {

    private Game game;
    int x = 0;
    int y = 0;
    int ya = 0;
    int vida;
    boolean cayendo = false;
    private static final int MAX_VIDA = 2;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 10;

    public Mao(Game game) {
        this.game = game;
        this.vida = MAX_VIDA;
    }

    public void paint(Graphics2D g) {
        switch (vida) {
            case 2 -> g.setColor(Color.BLACK);
            case 1 -> g.setColor(Color.RED);
            default -> g.setColor(Color.GRAY);
        }

        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void move() {
        if (cayendo) {
            y+=1;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void tocado() {
        vida--;
        if (vida == 0)
            cayendo = true;
    }

}
