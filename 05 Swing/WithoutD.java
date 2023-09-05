
import javax.swing.*;
import java.awt.event.*;

public class WithoutD extends JFrame {

    public WithoutD() {
        super("Event Handling Without Delegation");
        JButton button = new JButton("Click Me!");

        button.addActionListener(new ButtonClickListener());

        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(WithoutD.this, "Hello, Swing World!");
        }
    }

    public static void main(String[] args) {
        new WithoutD();
    }
}