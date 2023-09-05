import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExamCalc extends JFrame {
    ExamCalc() {
        super("Calculator");

        JPanel panel = new JPanel(new GridLayout(3, 1));
        JPanel topPanel = new JPanel(new GridLayout(2, 1));

        JTextField expressionField = new JTextField();
        JTextField resultField = new JTextField();
        topPanel.add(expressionField);
        topPanel.add(resultField);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        String[] btns = {
                "7", "8", "9", "-",
                "4", "5", "6", "+",
                "1", "2", "3", "*",
                "0", ".", "=", "/",
        };
        for (String btn : btns) {
            JButton b = new JButton(btn);
            buttonPanel.add(b);

            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String value = expressionField.getText();
                    String buttonText = b.getText();
                    expressionField.setText(value + buttonText);
                }
            });
        }

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        JButton delete = new JButton("Delete One");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentText = expressionField.getText();
                if (!currentText.isEmpty()) {
                    expressionField.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });

        JButton clear = new JButton("Clear All");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                expressionField.setText("");
            }
        });

        bottomPanel.add(delete);
        bottomPanel.add(clear);

        panel.add(topPanel);
        panel.add(buttonPanel);
        panel.add(bottomPanel);

        add(panel);
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ExamCalc();
    }

}
