import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class ScientificCalculator extends JFrame {
    private JTextField expressionField; // Field for the expression
    private JTextField resultField; // Field for the result
    private boolean showingResult = false;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the expression field
        expressionField = new JTextField();
        expressionField.setEditable(false);
        expressionField.setFont(new Font("Arial", Font.PLAIN, 24));
        expressionField.setBackground(Color.BLACK);
        expressionField.setForeground(Color.WHITE);
        expressionField.setBorder(new EmptyBorder(2, 10, 0, 0)); // Set border to zero
        expressionField.setPreferredSize(new Dimension(450, 35));
        expressionField.setMargin(new Insets(0, 0, 0, 0));

        // Create the result field
        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setFont(new Font("Arial", Font.PLAIN, 24));
        resultField.setBackground(Color.BLACK);
        resultField.setForeground(Color.WHITE);
        resultField.setBorder(new EmptyBorder(0, 350, 0, 0)); // Set border to zero
        resultField.setPreferredSize(new Dimension(450, 35));
        resultField.setMargin(new Insets(0, 0, 0, 0));

        // Create the panel for text fields using GridBagLayout
        JPanel textFieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 0, 0); // Set bottom gap to 5 (you can adjust this as needed)
        constraints.gridx = 0;
        constraints.gridy = 0;
        textFieldsPanel.add(expressionField, constraints);
        constraints.gridy = 1;
        textFieldsPanel.add(resultField, constraints);

        // Create the panel for buttons using GridBagLayout
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        constraints.insets = new Insets(5, 5, 5, 5);

        // Add the buttons using a loop
        String[] buttonLabels = {
                "(", ")", "^", "DEL", "AC",
                "7", "8", "9", "/", "sin",
                "4", "5", "6", "*", "cos",
                "1", "2", "3", "-", "tan",
                "0", ".", "%", "+", "=",
        };

        int gridX = 0;
        int gridY = 0;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));

            if (label.equals("=")) {
                button.setBackground(Color.decode("#8CABFF"));
                button.setForeground(Color.black);
            } else if ((label.equals("AC")) || label.equals("DEL")) {
                button.setBackground(Color.decode("#C51605"));
                button.setForeground(Color.white);
            } else {
                button.setBackground(Color.DARK_GRAY);
                button.setForeground(Color.white);
            }

            button.setPreferredSize(new Dimension(80, 60));
            constraints.gridx = gridX;
            constraints.gridy = gridY;
            constraints.gridwidth = 1;
            buttonPanel.add(button, constraints);
            gridX++;

            if (gridX > 4) {
                gridX = 0;
                gridY++;
            }

            // Add ActionListener to each button
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (label.equals("AC")) {
                        clearDisplay();
                    } else if (label.equals("DEL")) {
                        clearOne();
                    } else if (label.equals("=")) {
                        performCalculation();
                    } else {
                        if (showingResult) {
                            clearDisplay();
                            showingResult = false;
                        }
                        expressionField.setText(expressionField.getText() + label);
                    }
                }
            });

        }

        // Create the main content pane with BorderLayout
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add space around the button panel
        contentPane.add(textFieldsPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(contentPane);
        pack();
        setResizable(false); // Prevent resizing
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void clearDisplay() {
        expressionField.setText("");
        resultField.setText("");
    }

    private void clearOne() {
        String currentText = expressionField.getText();
        if (!currentText.isEmpty()) {
            expressionField.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    private void performCalculation() {
        String expression = expressionField.getText();
        double calculatedResult = evaluateExpression(expression);
        resultField.setText(String.valueOf(calculatedResult));
        showingResult = true;
    }

    private double evaluateExpression(String expression) {
        try {
            Stack<Double> numStack = new Stack<>();
            Stack<Character> opStack = new Stack<>();
            StringBuilder num = new StringBuilder();

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (Character.isDigit(ch) || ch == '.') {
                    num.append(ch);
                } else if (ch == '(') {
                    opStack.push(ch);
                    num.setLength(0); // Reset the num StringBuilder for the next number
                } else if (ch == ')') {
                    if (num.length() > 0) {
                        numStack.push(Double.parseDouble(num.toString()));
                        num.setLength(0);
                    }

                    while (!opStack.isEmpty() && opStack.peek() != '(') {
                        char op = opStack.pop();
                        if (op == 's' || op == 'c' || op == 't') {
                            double val = numStack.pop();
                            numStack.push(performTrigOperation(val, op));
                        } else {
                            double val2 = numStack.pop();
                            double val1 = numStack.pop();
                            numStack.push(performOperation(val1, val2, op));
                        }
                    }

                    opStack.pop(); // Remove the '(' from the operator stack
                } else if (isOperator(ch) || ch == 's' || ch == 'c' || ch == 't') {
                    if (num.length() > 0) {
                        numStack.push(Double.parseDouble(num.toString()));
                        num.setLength(0);
                    }

                    while (!opStack.isEmpty() && getPrecedence(opStack.peek()) >= getPrecedence(ch)) {
                        char op = opStack.pop();
                        if (op == 's' || op == 'c' || op == 't') {
                            double val = numStack.pop();
                            numStack.push(performTrigOperation(val, op));
                        } else {
                            double val2 = numStack.pop();
                            double val1 = numStack.pop();
                            numStack.push(performOperation(val1, val2, op));
                        }
                    }

                    opStack.push(ch);
                }
            }

            if (num.length() > 0) {
                numStack.push(Double.parseDouble(num.toString()));
            }

            while (!opStack.isEmpty()) {
                char op = opStack.pop();
                if (op == 's' || op == 'c' || op == 't') {
                    double val = numStack.pop();
                    numStack.push(performTrigOperation(val, op));
                } else {
                    double val2 = numStack.pop();
                    double val1 = numStack.pop();
                    numStack.push(performOperation(val1, val2, op));
                }
            }

            return numStack.pop();
        } catch (Exception e) {
            return Double.NaN; // Indicate an error in case of invalid expression
        }
    }

    private double performOperation(double val1, double val2, char op) {
        switch (op) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                return val1 / val2;
            case '^':
                return Math.pow(val1, val2);
            case '%':
                return val1 % val2;
            default:
                return Double.NaN; // Indicate an error in case of invalid operation
        }
    }

    private double performTrigOperation(double val, char op) {
        switch (op) {
            case 's':
                return Math.sin(val);
            case 'c':
                return Math.cos(val);
            case 't':
                return Math.tan(val);
            default:
                return Double.NaN; // Indicate an error in case of invalid operation
        }
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '%';
    }

    private int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            case '%':
                return 4;
            case 's':
            case 'c':
            case 't':
                return 5;
            default:
                return 0; // Lower precedence for invalid operators
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
