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
