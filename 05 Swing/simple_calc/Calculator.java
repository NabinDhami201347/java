
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    JTextField t1, t2, t3;

    Calculator() {
        JLabel l1 = new JLabel("Number 1");
        t1 = new JTextField();
        l1.setBounds(10, 10, 100, 20);
        t1.setBounds(100, 10, 100, 20);

        JLabel l2 = new JLabel("Number 2");
        t2 = new JTextField();
        l2.setBounds(10, 30, 100, 20);
        t2.setBounds(100, 30, 100, 20);

        JLabel l3 = new JLabel("Result");
        t3 = new JTextField();
        l3.setBounds(10, 50, 100, 20);
        t3.setBounds(100, 50, 100, 20);

        JButton sum = new JButton("Sum");
        sum.setBounds(50, 70, 60, 20);
        sum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(t1.getText());
                int num2 = Integer.parseInt(t2.getText());
                int result = num1 + num2;
                t3.setText(String.valueOf(result));
            }
        });

        JButton sub = new JButton("Sub");
        sub.setBounds(120, 70, 60, 20);
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(t1.getText());
                int num2 = Integer.parseInt(t2.getText());
                int result = num1 - num2;
                t3.setText(String.valueOf(result));
            }
        });

        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(t3);

        add(sum);
        add(sub);

        setLayout(null);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}