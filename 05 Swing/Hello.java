import javax.swing.*;

public class Hello extends JFrame {

    public Hello() {
        setTitle("My Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Click me!");
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Button clicked!");
        });

        getContentPane().add(button);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Hello app = new Hello();
            app.setVisible(true);
        });
    }
}