import javax.swing.*;
import java.awt.event.*;

// public class Example {
//     public static void main(String[] args) {
//         JFrame frame = new JFrame("Simple Swing Example");
//         JButton button = new JButton("Click Me!");

//         // button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Hello,
//         // Swing World!"));
//         button.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 JOptionPane.showMessageDialog(frame, "Hello, Swing World!");
//             }
//         });

//         frame.setLocationRelativeTo(null);

//         frame.add(button);
//         frame.setSize(300, 200);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);
//     }
// }

public class Example extends JFrame {
    private JButton button;

    public Example() {
        super("Simple Swing Example");

        button = new JButton("Click Me!");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Example.this, "Hello, Swing World!");
            }
        });

        setLocationRelativeTo(null);
        add(button);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Example();
    }
}
