import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Background extends JFrame {

    Background() {
        super("WOW IT'S BEAUTIFULL");

        JPanel panel = new JPanel();
        JButton btn = new JButton("SUBMIT");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.RED);
            }
        });

        panel.add(btn);
        add(panel);

        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Background();
    }
}
