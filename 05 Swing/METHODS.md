In Java, event handling in GUI applications can be done with and without delegation. Delegation involves using event listeners to handle events, while without delegation, you handle events by directly overriding methods provided by the components.

### Event Handling with Delegation (Using Event Listeners):

Delegation is the most common approach in Java GUI frameworks like Swing. Here's how event handling works with delegation:

1. Create an event listener class that implements the appropriate interface for the event you want to handle. For example, for a button click event, you would implement the `ActionListener` interface.

```java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle the event here
    }
}
```

2. Register the event listener with the component that generates the event. For example, for a button, you would use the `addActionListener` method:

```java
JButton button = new JButton("Click Me");
button.addActionListener(new MyActionListener());
```

3. When the event occurs (e.g., the button is clicked), the registered listener's `actionPerformed` method will be called to handle the event.

### Event Handling without Delegation (Directly Override Component Methods):

You can also handle events without using delegation by directly subclassing Swing components and overriding their event handling methods. Here's how it works:

1. Create a custom component class that extends the Swing component you want to customize, such as `JButton`:

```java
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton {
    public MyButton(String text) {
        super(text);

        // Add event handling logic directly within the custom component
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the button click event here
            }
        });
    }
}
```

2. In the constructor of your custom component, add the event handling logic directly to the component itself.

3. You can use your custom component in your application just like any other Swing component:

```java
MyButton customButton = new MyButton("Click Me");
```

With this approach, event handling logic is encapsulated within the custom component, and there's no need for separate event listener classes.

Both approaches have their use cases, and the choice between them depends on the complexity of your application and your preference for organizing and encapsulating event handling code. Delegation is generally more flexible and modular, making it suitable for larger applications where you may have multiple components sharing the same event listener logic. On the other hand, handling events without delegation can be simpler and more direct for small, self-contained components.
