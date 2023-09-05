# Event Handeling in JAVA


**Event handling in Java is the procedure that controls an event and performs appropriate action if it occurs. The code or set of instructions used to implement it is known as the Event handler. It consists of two major components i.e event source and event listener. The source is the object where the event occurs, and the event listener is responsible for taking appropriate actions when an event occurs. These Listeners must be registered with the source object in order for the listener to receive event notifications.**

![](https://scaler.com/topics/images/event-delegation-model.webp)

```java
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        textField.setText("Anonymous");
    }
});
```

```java
button.addActionListener(this);

public void actionPerformed(ActionEvent e) {
    textField.setText("GFG!");
}
```

```java
Outer o = new Outer(this);
b.addActionListener(o);// passing outer class instance

class Outer implements ActionListener {
    MyClass obj;

    Outer(MyClass obj) {
        this.obj = obj;
    }

    public void actionPerformed(ActionEvent e) {
        obj.tf.setText("Hello, outher here.");
    }
}
```
------------



![delegation method](https://media.geeksforgeeks.org/wp-content/uploads/20211108232732/event6.PNG)

`Events` are generated from the `source`. There are various sources like buttons, checkboxes, list, menu-item, choice, scrollbar, text components, windows, etc., to generate events.

```java
addTypeListener()
```

`Listeners` are used for handling the `events generated from the source`. Each of these listeners represents interfaces that are responsible for handling events.

## Anonymous Class

```java
class AnonymousClass extends Frame {
    TextField textField;

    AnonymousClass() {
        textField = new TextField();
        Button button = new Button("Click Here");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("Event Handled Anonymously");
            }
        });
    }
}
```

## Within Class

```java
class WithinClass extends Frame implements ActionListener {
    TextField textField;

    WithinClass() {
        textField = new TextField();
        Button button = new Button("Click Here");
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        textField.setText("Event Handled Within the Class");
    }
}
```
   
## Outside Class

```java
class OutsideClass extends Frame {
    TextField textField;

    OutsideClass() {
        textField = new TextField();
        Button button = new Button("Click Here");

        Outer outer = new Outer(this);
        button.addActionListener(outer);
    }
}

class Outer implements ActionListener {
    OutsideClass outer;

    Outer(OutsideClass outer) {
        this.outer = outer;
    }

    public void actionPerformed(ActionEvent e) {
        outer.textField.setText("Event Handled in Different Class");
    }
}
```

