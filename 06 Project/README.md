





```java 
displayField = new JTextField();
displayField.setEditable(false);
displayField.setFont(new Font("Arial", Font.PLAIN, 24));
displayField.setBackground(Color.BLACK);
displayField.setForeground(Color.WHITE);
displayField.setPreferredSize(new Dimension(400, 70));
```


```java
JPanel buttonPanel = new JPanel(new GridBagLayout());
GridBagConstraints constraints = new GridBagConstraints();
constraints.fill = GridBagConstraints.BOTH;
constraints.insets = new Insets(5, 5, 5, 5);
```

> ***The `GridBagLayout` is a flexible layout manager that allows you to arrange components in rows and columns with different sizes and alignment. The `GridBagConstraints` class is used to define constraints for components when they are added to the GridBagLayout. It allows you to specify properties such as the component's position, size, alignment, and padding. This line sets the fill property of the GridBagConstraints to GridBagConstraints.BOTH. This means that the buttons in the buttonPanel will expand both horizontally and vertically to fill the available space within their respective cells. The insets property of the GridBagConstraints allows you to specify the external padding (empty space) around a component when it's placed in a cell. Here, an Insets object is created with top, left, bottom, and right insets all set to 5 pixels. This adds a 5-pixel gap around each button.***



```java
String[] buttonLabels = {
    "7", "8", "9", "/", "sqrt",
    "4", "5", "6", "*", "%",
    "1", "2", "3", "-", "1/x",
    "0", ".", "+/-", "+", "=",
    "C", "sin", "cos", "tan", "log"
};
```


```java
int gridX = 0;
int gridY = 0;
for (String label : buttonLabels) {
    JButton button = new JButton(label);
    button.setFont(new Font("Arial", Font.PLAIN, 20));
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
}
```

> ***The two integer variables are used to keep track of the current column `gridX` and row `gridY` positions in the grid layout. The gridX and gridY will be updated in the loop to position the buttons in the `buttonPanel`. The `setPreferredSize` method sets the preferred size of the button. All buttons will have a preferred width of 80 pixels and a preferred height of 60 pixels. This ensures a consistent button size throughout the calculator. The code `constraints.gridx = gridX` and `constraints.gridy = gridY` set the current cell position in the `GridBagConstraints`. The gridX and gridY variables keep track of the current column and row position where the button should be placed. Each button is placed in a specific cell in the grid. The code `constraints.gridwidth = 1` allows you to specify how many cells a component should occupy horizontally. The button is added to the buttonPanel with the current constraints. The buttonPanel is using GridBagLayout, and these constraints define the position and size of the button within the grid.***


```java
JPanel contentPane = new JPanel(new BorderLayout());
contentPane.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add space around the button panel
contentPane.add(displayField, BorderLayout.NORTH);
contentPane.add(buttonPanel, BorderLayout.CENTER);

setContentPane(contentPane);
pack();
setResizable(false); // Prevent resizing
setLocationRelativeTo(null);
setVisible(true);
```


> ***The `BorderLayout` is a common layout manager that arranges components in five regions: North, South, East, West, and Center. Here, we will use the BorderLayout to organize the display field at the top (North) and the button panel at the center (Center). The `pack()` is used to resize the frame to fit the preferred sizes of its components. It ensures that the frame will be sized correctly to show all its components without unnecessary empty space. The `setBorder()` allows us to set a border around the content pane. In this case, we use `EmptyBorder`, which is a type of border that adds empty space around the component. Here, we set the top, left, bottom, and right margins of the contentPane to 10 pixels each, adding space around the button panel. The `setLocationRelativeTo()` positions the frame in the center of the screen. By passing null, it centers the frame on the screen, and the frame will appear at the center of the user's display.***

```java
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        onButtonClick(label);
    }
});
```

```java
private void onButtonClick(String label) {
    if (label.equals("C")) {
            displayField.setText("");
    } else {
        displayField.setText(displayField.getText() + label);
    }
}
```