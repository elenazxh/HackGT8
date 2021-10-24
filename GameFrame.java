import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame implements ActionListener {
    PaintThread pt;
    static int difficulty = 0;
    static Image beeImage;
    Bee bee = new Bee(beeImage, 100, 100, 14);
    Image bg = GameUtil.getImage("images/campus.png");
    Image imageOfVirus = GameUtil.getImage("images/virus2times.png");
    Virus[] virus = new Virus[20];
    Explode explode;
    Date start = new Date();
    Date end;
    long period = 0;

    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        Color c = g.getColor();
        g.setColor(new Color(0x003057));
        g.setFont(new Font("Times", Font.BOLD, 50));
        if (bee.live) {
            period = (System.currentTimeMillis() - start.getTime()) / 1000;
            g.drawString("time: " + period, 30, 120);
        } else {
            if (end == null) {
                end = new Date();
                period = (end.getTime() - start.getTime()) / 1000;
            }
        }
        Font f = g.getFont();

        if (bee.live == false) {
            g.drawString("Survival time: " + period + " seconds", 165, 450);
            Timer timer = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    ExplanationFrame ef = null;
                    if (ef == null) {
                        new ExplanationFrame(difficulty);
                    }
                }
            });
            timer.setRepeats(false);
            timer.start();
            pt.interrupt();
            repaint();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        g.setColor(c);
        g.setFont(f);
        bee.drawMyself(g);
        // Draw virus
        for (int i = 0; i < virus.length; i++) {
            virus[i].drawMyself(g);
            boolean peng = virus[i].getRec().intersects(bee.getRec());
            if (peng) {
                bee.live = false;
                if (explode == null) {
                    explode = new Explode(bee.x, bee.y);
                }
                explode.drawMyself(g);
            }
        }
    }

    public GameFrame(int virusSpeed) {
        this.setResizable(false);
        this.setTitle("COVID WAR");
        setVisible(true);// visible
        setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);// the size of window
        setLocationRelativeTo(null);// the start locarion of the game frame
        // colse the window
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        pt = new PaintThread();
        pt.start(); // start thread
        this.addKeyListener(new KeyMonitor());// start key monitor

        for (int i = 0; i < virus.length; i++) {
            virus[i] = new Virus(imageOfVirus, 500, 500, virusSpeed);
        }
    }

    public GameFrame() {
    }

    class PaintThread extends Thread {
        int interval = 50;
        final AtomicBoolean running = new AtomicBoolean(false);

        @Override
        public void run() {
            running.set(true);
            while (running.get()) {
                repaint();
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void interrupt() {
            running.set(false);
            this.interrupt();
        }
    }

    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            bee.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            bee.minusDirection(e);
        }
    }

    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ExplanationFrame ef = null;
        this.dispose();
        if (ef == null) {
            new ExplanationFrame(difficulty);
        }
        return;
    }
}