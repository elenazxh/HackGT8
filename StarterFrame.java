import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StarterFrame extends JFrame implements ActionListener {

    JButton jb1 = new JButton("Totally Unprotected Mode");
    JButton jb2 = new JButton("Masked Mode");
    JButton jb3 = new JButton("Vaccinated Mode");
    JButton jb4 = new JButton("Masked & Vaccinated Mode");
    JButton jb5 = new JButton("Exit");

    public StarterFrame() {
        GamePanel panel = new GamePanel();
        panel.setLayout(null);

        jb1.setSize(new Dimension(200, 50));
        jb2.setSize(new Dimension(200, 50));
        jb3.setSize(new Dimension(200, 50));
        jb4.setSize(new Dimension(200, 50));
        jb5.setSize(new Dimension(200, 50));

        panel.add(jb1);
        panel.add(jb2);
        panel.add(jb3);
        panel.add(jb4);
        panel.add(jb5);

        jb1.setLocation(350, 320);
        jb2.setLocation(350, 390);
        jb3.setLocation(350, 460);
        jb4.setLocation(350, 530);
        jb5.setLocation(350, 600);

        getContentPane().add(panel, "Center");

        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        this.setTitle("COVID WAR");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            this.dispose();
            GameFrame.beeImage = GameUtil.getImage("images/bee2times.png");
            GameFrame.difficulty=4;
            new GameFrame(12);// shell speed for the hard mode
        } else if (e.getSource() == jb2) {
            this.dispose();
            GameFrame.beeImage = GameUtil.getImage("images/maskbee2times.png");
            GameFrame.difficulty=3;
            new GameFrame(9);// shell speed for the mid mode
        } else if (e.getSource() == jb3) {
            this.dispose();
            GameFrame.beeImage = GameUtil.getImage("images/beevaccine2times.png");
            GameFrame.difficulty=2;
            new GameFrame(7);// shell speed for the mid mode
        } else if (e.getSource() == jb4) {
            this.dispose();
            GameFrame.beeImage = GameUtil.getImage("images/strongbee.png");
            GameFrame.difficulty=1;
            new GameFrame(5);// shell speed for the easy mode
        } else if (e.getSource() == jb5) {
            System.exit(0);
        }
    }
}