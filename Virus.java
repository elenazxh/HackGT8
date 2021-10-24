import java.awt.*;
import java.awt.Graphics;

public class Virus extends GameObject {
    double degree;// move with given degree

    public Virus(Image img, double x, double y, int speed) {
        super(img, x, y, speed);
        degree = Math.random() * Math.PI * 2;

    }

    @Override
    public void drawMyself(Graphics g) {
        // the move path of virus
        super.drawMyself(g);
        this.x += speed * Math.cos(degree);
        this.y += speed * Math.sin(degree);

        // Change direction with border
        if (y > Constant.GAME_HEIGHT - this.height || y < 40) {
            degree = -degree;
        }
        if (x < 0 || x > Constant.GAME_WIDTH - this.width) {
            degree = Math.PI - degree;
        }
    }
}
