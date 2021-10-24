import java.awt.*;
import java.awt.event.KeyEvent;

public class Bee extends GameObject {
    boolean left, right, up, down;
    boolean live = true;// does the bee live

    @Override
    public void drawMyself(Graphics g) {
        if (live) {
            super.drawMyself(g);
            if (left && x > this.width) {
                x -= speed;
            }
            if (right && x < Constant.GAME_WIDTH - this.width) {
                x += speed;
            }
            if (up && y > this.height) {
                y -= speed;
            }
            if (down && y < Constant.GAME_HEIGHT - this.height) {
                y += speed;
            }
        }
    }

    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
            left = true;
            break;
        case KeyEvent.VK_RIGHT:
            right = true;
            break;
        case KeyEvent.VK_UP:
            up = true;
            break;
        case KeyEvent.VK_DOWN:
            down = true;
            break;
        }
    }

    public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
            left = false;
            break;
        case KeyEvent.VK_RIGHT:
            right = false;
            break;
        case KeyEvent.VK_UP:
            up = false;
            break;
        case KeyEvent.VK_DOWN:
            down = false;
            break;
        }
    }

    public Bee(Image img, double x, double y, int speed) {
        super(img, x, y, speed);
    }
}
