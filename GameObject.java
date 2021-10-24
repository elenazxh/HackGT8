import java.awt.*;

public class GameObject {
    Image img;
    double x, y;
    int speed;
    int width, height;

    // constructor
    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image img, double x, double y, int speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    public GameObject() {
    }

    // draw game object
    public void drawMyself(Graphics g) {
        g.drawImage(img, (int) x, (int) y, width, height, null);
    }

    // return a rectangle of the object
    public Rectangle getRec() {
        return new Rectangle((int) x, (int) y, width, height);
    }
}
