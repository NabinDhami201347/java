```java
import java.applet.Applet;
import java.awt.Graphics;

public class SimpleApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello, Applet!", 50, 50);
    }
}
```

> **_An applet is a Java program that can be embedded into a web page. It runs inside the web browser and works at client side._**

```html
<html>
  <body>
    <applet code="SimpleApplet.class" width="200" height="100"> Your browser does not support Java applets. </applet>
  </body>
</html>
```

```java
import java.applet.Applet;
import java.awt.Graphics;

public class MyApplet extends Applet {

    public void init() {
        // It is used to initialized the Applet. It is invoked only once.
    }
    public void start() {
        // It is invoked after the init() method or browser is maximized. It is used to start the Applet.
    }

    public void paint(Graphics g) {
        // Drawing code here
    }

    public void stop() {
        // It is used to stop the Applet. It is invoked when Applet is stop or browser is minimized.
    }

    public void destroy() {
        // It is used to paint the Applet. It provides Graphics class object that can be used for drawing oval, rectangle
    }
}
```

## Applet vs Application

| Aspect                    | Java Application                              | Java Applet                                           |
| ------------------------- | --------------------------------------------- | ----------------------------------------------------- |
| **Execution Environment** | Standalone, runs independently of browsers    | Embedded within web browsers                          |
| **Entry Point**           | Has a `main` method as the entry point        | Does not have a `main` method; uses lifecycle methods |
| **User Interface**        | Can have GUI (e.g., Swing, JavaFX) or CLI     | Limited user interface, often within the browser      |
| **Resource Access**       | Unrestricted access to system resources       | Restricted access due to browser sandboxing           |
| **File Operations**       | Can perform extensive file and network I/O    | Limited file access due to security concerns          |
| **Security**              | Subject to fewer security restrictions        | Runs in a browser sandbox, stringent security         |
| **Network Access**        | Can make network requests freely              | Subject to same-origin policy for network access      |
| **Local File Access**     | Has extensive access to the local file system | Limited local file access, requires user permission   |

> In summary, Java applications run independently and have broader capabilities, while Java applets are embedded in web pages, operate with tighter security constraints within browser sandboxes, and offer limited user interfaces. Java applications remain a common choice for standalone software, while Java applets have largely faded from modern web development due to security considerations.

```java
import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InteractiveApplet extends Applet implements ActionListener {
    private String message = "Click the button to change me!";
    private Button changeButton;

    public void init() {
        changeButton = new Button("Change Text");
        changeButton.addActionListener(this);
        add(changeButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeButton) {
            message = "Text has been changed!";
            repaint(); // Request a repaint to update the display
        }
    }

    public void paint(Graphics g) {
        g.drawString(message, 50, 50);
    }
}
```

## Converting an Applet to an Application

```java
import java.awt.*;
import java.applet.Applet;

public class MyApplet extends Applet {
    public void paint(Graphics g){
        g.drawString("Hello World", 100,100)
    }
}
```

```java
import java.awt.*;
import javax.swing.*;

public class MyApplet extends JFrame {
    public MyApplet(){
        super("My Frame");

        JLabel l = new JLabel("Hello World");
        add(l);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(100,100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyApplet();
    }
}
```
