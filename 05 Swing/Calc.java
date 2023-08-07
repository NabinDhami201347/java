import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class Calc extends JFrame {

    JTextField sres, fnumber, snumber;

    Calc() {
        JLabel fnum = new JLabel("First Number");
        fnumber = new JTextField();

        JLabel snum = new JLabel("Second Number");
        snumber = new JTextField();

        JLabel res = new JLabel("Result");
        sres = new JTextField();

        JButton sum = new JButton("Sum");
        sum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult('+');
            }
        });

        JButton diff = new JButton("Diff");
        diff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult('-');
            }
        });

        add(fnum);
        add(fnumber);
        add(snum);
        add(snumber);
        add(res);
        add(sres);
        add(sum);
        add(diff);

        setLayout(new GridLayout(4, 2));
        setSize(200, 200);
        setVisible(true);
    }

    private void calculateResult(char operator) {
        int num1 = Integer.parseInt(fnumber.getText());
        int num2 = Integer.parseInt(snumber.getText());
        int result;

        if (operator == '+') {
            result = num1 + num2;
        } else {
            result = num1 - num2;
        }

        sres.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new Calc();
    }
}
