import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class Login extends JFrame {
    Login() {
        super("Authentication");

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel username = new JLabel("Username");
        JTextField tusername = new JTextField();

        JLabel password = new JLabel("Password");
        JTextField tpassword = new JTextField();

        JButton login = new JButton("Login");

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = tusername.getText();
                String password = tpassword.getText();

                if (username.equals("nabin") && password.equals("123")) {
                    JOptionPane.showMessageDialog(panel, "Successfully Logged in");
                } else {
                    JOptionPane.showMessageDialog(panel, "Login Failed");
                    tusername.setText("");
                    tpassword.setText("");
                }
            }
        });

        panel.add(username);
        panel.add(tusername);
        panel.add(password);
        panel.add(tpassword);
        panel.add(login);

        add(panel);
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
    }
}
