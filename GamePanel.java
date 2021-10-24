import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    public GamePanel() {
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the background
        g.setColor(new Color(0xB3A369));
        g.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        g.setColor(new Color(0x003057));
        g.setFont(new Font("Times", Font.BOLD, 48));
        g.drawString("WELCOME TO OUR COVID GAME", 70, 250);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

}
