# [Java Swing](https://www.geeksforgeeks.org/introduction-to-java-swing/)

**Java Swing is a set of graphical user interface (GUI) components and tools provided by Java for building desktop applications. It is part of the Java Foundation Classes (JFC) and is a powerful framework for creating interactive and visually appealing applications. Swing is built on top of the Abstract Window Toolkit (AWT) and offers several advantages over AWT, including platform independence, a rich set of components, customizable look and feel, and support for internationalization and accessibility. Swing provides a wide range of pre-built components, such as buttons, text fields, checkboxes, menus, and dialog boxes, which can be easily customized and arranged to create complex user interfaces. It follows a model-view-controller (MVC) architecture, where the components (view) are separate from the underlying data (model) and the logic that manipulates the data (controller).**

```java
import javax.swing.*;

public class MyApplication extends JFrame {

    public MyApplication() {
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
            MyApplication app = new MyApplication();
            app.setVisible(true);
        });
    }
}
```

> **_Panel is a class in the Java Swing framework that represents a container component used to hold and organize other components. It is a lightweight container that can be added to other containers like JFrame or other JPanel instances. JPanel provides a blank canvas where you can place other Swing components such as buttons, labels, text fields, etc., and arrange them using layout managers._**

![](https://cdn.educba.com/academy/wp-content/uploads/2020/03/JPanel-vs-JFrame-1.jpg)

> **_JFrame is a top-level container that represents the main window or frame of a Swing application. It provides the overall window frame, including the title bar, border, and controls such as minimize, maximize, and close buttons. JFrame is typically used as the main container to hold and manage other components, such as JPanel instances, buttons, menus, and more. It is responsible for managing the overall structure and appearance of the application window._**

> **_JPanel is a lightweight container that is used to organize and hold other components, such as buttons, labels, text fields, and more. It does not have its own window frame or title bar. Instead, JPanel is commonly used as a building block for creating complex layouts within a JFrame or other JPanel instances. It allows you to group related components together and apply layout managers to control their positioning and arrangement._**

> **_JFrame represents the main window of a Swing application and provides the outer container with a frame-like appearance, while JPanel serves as an inner container used for organizing and grouping components within the JFrame or other JPanel instances. Both JFrame and JPanel are crucial components in creating GUI applications, with JFrame acting as the main container and JPanel facilitating the organization and layout of components._**
