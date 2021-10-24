import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExplanationFrame extends JFrame implements ActionListener {
    int difficulty;
    JButton again = new JButton("AGAIN");
    JButton exit = new JButton("EXIT");

    public ExplanationFrame(int difficulty) {
        this.difficulty = difficulty;
        GamePanel panel = new GamePanel();
        panel.setLayout(null);

        again.setSize(new Dimension(100, 35));
        exit.setSize(new Dimension(100, 35));
        again.setLocation(250, 750);
        exit.setLocation(550, 750);

        panel.add(again);
        panel.add(exit);

        getContentPane().add(panel, "Center");
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        this.setTitle("COVID WAR");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        again.addActionListener(this);
        exit.addActionListener(this);
    }

    public void paint(Graphics g) {

        g.setColor(new Color(0xB3A369));
        switch (difficulty) {
        case 4:
            g.setFont(new Font("Times", Font.BOLD, 35));
            g.drawString("Oh no! You have no protection against Covid-19 and ", 40, 100);
            g.drawString("this is not good. Out of the four modes, this mode is ", 40, 200);
            g.drawString("the most vulnerable to the virus and you are very likely ", 40, 300);
            g.drawString("to get infected. Please wear a mask, get vaccinated, ", 40, 400);
            g.drawString("and get tested as soon as possible! You’re not only ", 40, 500);
            g.drawString("helping yourself, but also helping others around you!", 40, 600);
            break;
        case 3:
            g.setFont(new Font("Times", Font.BOLD, 30));
            g.drawString("Oh no! You have been infected with Covid-19! However, ", 60, 100);
            g.drawString("good job in wearing a mask. By blocking out larger ", 60, 180);
            g.drawString("respiratory drops and infected particles, face coverings", 60, 260);
            g.drawString("cut down the chances of both transmitting and catching ", 60, 340);
            g.drawString("the coronavirus. Studies show that they can reduce the ", 60, 420);
            g.drawString("risk of infection by 70%. However, you are still strongly", 60, 500);
            g.drawString("encouraged to get the  Covid-19 vaccine and get tested as", 60, 580);
            g.drawString("soon as possible.", 40, 660);
            break;
        case 2:
            g.setFont(new Font("Times", Font.BOLD, 30));
            g.drawString("Oh no! You have been infected with Covid-19! However, good", 60, 70);
            g.drawString("job in getting a vaccine. When fighting illnesses, your ", 60, 140);
            g.drawString("body’s immune system uses white blood cells to deal with ", 60, 210);
            g.drawString("infection. Vaccines work by introducing a harmless version", 60, 280);
            g.drawString("of a virus to your cells so that they recognize it and make", 60, 350);
            g.drawString("“memory” cells which will remember how to fight the virus if", 60, 420);
            g.drawString("you are ever infected in the future. The vaccine reduces the", 60, 490);
            g.drawString("risk of catching the disease by 93% and reduces the severity", 60, 560);
            g.drawString("for the remaining 7%. Since no vaccine is 100% effective,", 50, 630);
            g.drawString("you are strongly encouraged to wear a mask and get tested", 60, 700);
            break;
        case 1:
            g.setFont(new Font("Times", Font.BOLD, 30));
            g.drawString("Oh no! You have been infected with Covid-19! However, great", 40, 100);
            g.drawString("job in wearing a mask and getting vaccinated. Thank you for", 40, 200);
            g.drawString("protecting not only yourself, but also everyone around you. ", 40, 300);
            g.drawString("Unfortunately, it is not possible to be completely immune to ", 40, 400);
            g.drawString("Covid-19. Please remain in quarantine until you receive a ", 40, 500);
            g.drawString("negative-test result and continue exercising your safety measures.", 40, 600);
            break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == again) {
            this.dispose();
            new StarterFrame();
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}