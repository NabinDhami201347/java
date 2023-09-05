# [Java Swing](https://www.geeksforgeeks.org/introduction-to-java-swing/)

Java Swing is a set of graphical user interface (GUI) components and tools provided by Java for building desktop applications. It is part of the Java Foundation Classes (JFC) and is a powerful framework for creating interactive and visually appealing applications. Swing is built on top of the Abstract Window Toolkit (AWT) and offers several advantages over AWT, including platform independence, a rich set of components, customizable look and feel, and support for internationalization and accessibility. Swing provides a wide range of pre-built components, such as buttons, text fields, checkboxes, menus, and dialog boxes, which can be easily customized and arranged to create complex user interfaces. It follows a model-view-controller (MVC) architecture, where the components (view) are separate from the underlying data (model) and the logic that manipulates the data (controller).

```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSwingExample {
    public static void main(String[] args) {
        // Create a JFrame (window) with a title
        JFrame frame = new JFrame("Simple Swing Example");

        // Create a JButton (button) with a label
        JButton button = new JButton("Click Me!");

        // Add an ActionListener to the button to handle button clicks
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Hello, Swing World!");
            }
        });

        // Add the button to the content pane of the JFrame
        frame.getContentPane().add(button);

        // Set the default close operation (what happens when the window is closed)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the window
        frame.setSize(300, 200);

        // Center the window on the screen
        frame.setLocationRelativeTo(null);

        // Make the window visible
        frame.setVisible(true);
    }
}
```

| Java AWT                                 | Java Swing                                      |
| ---------------------------------------- | ----------------------------------------------- |
| AWT components are platform-dependent.   | Java swing components are platform-independent. |
| AWT components are heavyweight.          | Swing components are lightweight.               |
| AWT provides less components than Swing. | Swing provides more powerful components.        |
| AWT doesn't follows MVC.                 | Swing follows MVC.                              |
