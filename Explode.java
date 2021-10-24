import java.awt.*;

public class Explode {
    double x, y;// the position

    static Image[] imgs = new Image[16];
    int count;

    // initialize the arr with imgs
    static {
        for (int i = 0; i < 16; i++) {
            imgs[i] = GameUtil.getImage("images/explode/e" + (i + 1) + ".gif");
        }
    }

    public void drawMyself(Graphics g) {
        if (count < 16) {
            g.drawImage(imgs[count], (int) x, (int) y, null);
            count++;
        }
    }

    // Constructor initialize the position with plane die's position
    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
