```java
JPanel buttonPanel = new JPanel();
buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

String[] buttonLabels = {
    "7", "8", "9", "/",
    "4", "5", "6", "*",
    "1", "2", "3", "-",
    "0", ".", "=", "+"
};

for (String label : buttonLabels) {
    JButton button = new JButton(label);
    button.setFont(new Font("Arial", Font.BOLD, 20));
    buttonPanel.add(button);
}

add(buttonPanel);
```

```java
    public Calc() {
        super("Calculator");

        JTextField textField = new JTextField();
        JTextField resultField = new JTextField();

        JPanel topPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        topPanel.add(textField);
        topPanel.add(resultField);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (label.equals("=")) {
                        resultField.setText("Here is the result");
                    } else {
                        String currentText = textField.getText();
                        textField.setText(currentText + label);
                    }
                }
            });
        }

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(topPanel, BorderLayout.NORTH); // Place the text field at the top
        contentPanel.add(buttonPanel, BorderLayout.CENTER); // Place the button panel in the center

        add(contentPanel); // Add the main content panel to the frame
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
```
