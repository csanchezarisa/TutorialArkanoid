import assets.sonidos.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {

    Ball ball;
    Racquet racquet;
    Mao mao = new Mao(this);
    int speed = 1;

    public int getScore() {
        return speed - 1;
    }

    private void move() {
        ball.move();
        racquet.move();
        mao.move();
    }

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }
        });
        ball = new Ball(this);
        racquet = new Racquet(this);
        setFocusable(true);
        Sound.BACK.loop();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        ball.paint(g2d);
        racquet.paint(g2d);
        mao.paint(g2d);
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString("Score: " + getScore(), 10, 30);
    }

    public void gameOver() {
        Sound.BACK.stop();
        Sound.GAME_OVER.play();
        JOptionPane.showMessageDialog(
                this,
                "Your score is " + getScore(),
                "Game Over",
                JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Arkanoid");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
